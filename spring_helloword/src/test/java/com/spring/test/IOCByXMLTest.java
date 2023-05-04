package com.spring.test;

import com.spring.pojo.Clazz;
import com.spring.pojo.Person;
import com.spring.pojo.Person2;
import com.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByXMLTest {

    @Test
    public void testIOC(){

        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applictionContext.xml");
        //获取bean方式1-根据id
        /*Student student1 = (Student) ioc.getBean("student1");
        System.out.println(student1);*/

        Student student = ioc.getBean(Student.class);
        Person person = ioc.getBean(Person.class);
        Person2 person2 = ioc.getBean(Person2.class);
        person.test();
        System.out.println(person);
        System.out.println(person2);
    }
    @Test
    public void testDI(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applictionContext.xml");
        Student student2 = ioc.getBean("student2", Student.class);
        System.out.println(student2);
    }
    @Test
    public void testClazz(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applictionContext.xml");
        Clazz clazz = ioc.getBean("clazz-list", Clazz.class);
        System.out.println(clazz);
    }
    @Test
    public void testList(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applictionContext.xml");
        Clazz clazz = ioc.getBean("clazz2", Clazz.class);
        System.out.println(clazz);
    }
    @Test
    public void testMap(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applictionContext.xml");
        Student student = ioc.getBean("student5", Student.class);
        System.out.println(student);
    }
}
