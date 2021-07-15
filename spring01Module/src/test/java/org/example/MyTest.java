package org.example;

import org.example.service.SomeService;
import org.example.service.impl.OtherService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest {

    //spring创建对象调用的是什么方法: 默认是类的无参构造
    //如果定义了有参构造 必须定义一个无参构造
    @Test
    public void test01(){
        String config="beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        SomeService service = ctx.getBean(SomeService.class);
        service.doSome();
    }
    //Spring在什么时候创建的对象：在创建spring容器对象的时候，会读取配置文件，创建文件中声明的java对象

    //获取容器中的对象的信息
    @Test
    public void test04(){
        String config="beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        //获取容器对象个数
        int num = ctx.getBeanDefinitionCount();
        System.out.println("获取容器对象个数:"+num);

        //获取容器定义的对象的名称
        String[] names = ctx.getBeanDefinitionNames();
        for(String name:names){
            System.out.println("对象的名称"+name);
        }
    }

    //spring 创建非自定义的对象 有class就能让spring创建对象
    @Test
    public void test05(){
        String config="beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        Date date = (Date) ctx.getBean("myDate");
        System.out.println("date == "+date);

        OtherService otherService = (OtherService) ctx.getBean("otherService");
        otherService.doOther();
    }
}
