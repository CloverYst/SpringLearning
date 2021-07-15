package org.example;

import org.example.ba03.Student;
import org.example.ba03.School;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest03 {
    @Test
    public void test01(){
        String config="ba03/applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Student student = (Student) ctx.getBean("myStudent2");
        System.out.println("Student="+student);
    }
}
