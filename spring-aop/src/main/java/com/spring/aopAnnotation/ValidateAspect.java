package com.spring.aopAnnotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
//设置切面优先级，数字越小优先级越高
@Order(1)
public class ValidateAspect {

    @Before("com.spring.aopAnnotation.LoggerAspect.pointcut()")
    public void beforeAdviceMethod(JoinPoint joinPoint){
        //获取连接点对应方法的方法名
        Signature signature = joinPoint.getSignature();
        //获取连接点对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("前置验证通知,方法："+signature.getName()+"  方法对应的参数："+ Arrays.toString(args));
    }



}
