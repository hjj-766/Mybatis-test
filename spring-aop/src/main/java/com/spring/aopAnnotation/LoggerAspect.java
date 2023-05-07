package com.spring.aopAnnotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//切面
@Component
@Aspect//将当前组件表示为切面类
public class LoggerAspect {
    /*@Before("execution(public int com.spring.aopAnnotation.CalculatorPureImpl.add(int ,int ))")*/
    /*第一个*表示任意的访问修饰符和返回值类型
    * 第二个*表示类中的任意方法
    * ..表示任意的参数列表
    * 类的地方用*表示包下所有的类
    * */

    /*声明公共的切入点表达式*/
    @Pointcut("execution(* com.spring.aopAnnotation.CalculatorPureImpl.*(..))")
    public void pointcut(){}

    @Before("execution(* com.spring.aopAnnotation.CalculatorPureImpl.*(..))")
    public void beforeAdviceMethod(JoinPoint joinPoint){
        //获取连接点对应方法的方法名
        Signature signature = joinPoint.getSignature();
        //获取连接点对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("前置通知,方法："+signature.getName()+"  方法对应的参数："+ Arrays.toString(args));
    }
    @After("pointcut()")
    public void afterAdviceMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->后置通知，方法名："+methodName);
    }
    @AfterReturning(value = "pointcut()", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->返回通知，方法名："+methodName+"，结果："+result);
    }
    @AfterThrowing(value = "pointcut()", throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->异常通知，方法名："+methodName+"，异常："+ex);
    }
        /*环绕通知和前面手动申明的通知作用相同，只用其中一种即可*/
    @Around(value = "pointcut()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        Object result = null;
        try {
            System.out.println("环绕通知-->目标对象方法执行之前："+"方法实参："+args);
            //目标方法的执行，目标方法的返回值一定要返回给外界调用者
            result = joinPoint.proceed();
            System.out.println("环绕通知-->目标对象方法返回值之后:"+" 方法名："+methodName+" 结果："+result);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知-->目标对象方法出现异常时");
        } finally {
            System.out.println("环绕通知-->目标对象方法执行完毕");
        }
        return result;
    }


}
