package com.spring.test;

import com.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {
    @Test
    public void testLifeCycle(){
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
/*
        User user = ioc.getBean(User.class);
        System.out.println(user);
        ioc.close();
*/



    }
}
