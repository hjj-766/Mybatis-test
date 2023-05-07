package com.spring.test;

import com.spring.controller.UserController;
import com.spring.dao.UserDao;
import com.spring.dao.impl.UserDaoImpl;
import com.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByAnnotationTest {
    @Test
    public void testIOCByAnnotation(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = ioc.getBean("userController",UserController.class);
        UserService userService = ioc.getBean("userServiceImpl",UserService.class);
        UserDao userDao = ioc.getBean("userDaoImpl",UserDao.class);
        System.out.println(userController);
        System.out.println(userDao);
        System.out.println(userService);
        userController.saveUser();

    }
    private UserDaoImpl userDao ;
    @Test
    public void testReflect() throws ClassNotFoundException {
        UserDao userDao1 = new UserDaoImpl();
        userDao1.saveUser();
        Class<? extends UserDao> aClass = userDao1.getClass();
        System.out.println(aClass);
        ClassLoader classLoader = userDao1.getClass().getClassLoader();
        System.out.println(classLoader);
        Class<?> aClass1 = Class.forName("com.spring.dao.impl.UserDaoImpl");
        System.out.println(aClass1);
        Class<?>[] interfaces = userDao1.getClass().getInterfaces();
        System.out.println(interfaces);


    }
}
