package org.example;

import org.example.service.SomeService;
import org.example.service.impl.SomeServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {
    public static void main(String[] args) {
//        SomeService service = new SomeServiceImpl();
//        service.doSome();

        //使用spring所管理的对象
        //1.指定spring配置文件：从类路径（classpath）之下开始的路径
        String config="beans.xml";
        //2.创建容器对象  从类路径中读取配置文件
        //ApplicationContext 表示spring容器对象 通过这个容器就可以获取你要使用的对象
        ApplicationContext ctx= new ClassPathXmlApplicationContext(config);
        //3.从容器中获取指定名称的对象 使用getBean("id")
        SomeService service = (SomeService) ctx.getBean("someService");
        //4.调用对象的方法
        service.doSome();
    }
}