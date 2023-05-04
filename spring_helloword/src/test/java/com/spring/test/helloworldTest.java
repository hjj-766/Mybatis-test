package com.spring.test;

import com.spring.pojo.Helloworld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class helloworldTest {

    @Test
    public void test(){
        /*获取IOC容器*/
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applictionContext.xml");
        //获取容器中的bean对象
        Helloworld helloworld = (Helloworld) ioc.getBean("helloworld");
        helloworld.sayhello();

    }
}
