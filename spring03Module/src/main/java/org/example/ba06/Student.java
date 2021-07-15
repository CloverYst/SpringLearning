package org.example.ba06;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component(value = "myStudent")
public class Student {
    @Value("${myname}")
    private String name;
    @Value("${myage}")
    private int age;

    /**
    * 引用类型
    * @resource: 来自jdk 给引用类型赋值
     *  默认byName byType
     *  spring 支持这个注解的使用
     *  位置: 1)在属性上面定义，无需set方法，推荐使用 2）在set方法上面
     *
     */
    //默认byName自动注入
    //先使用byName跟其同名的shcool
    //如果赋值失败用byType同源 本例子是byType
    @Resource
    private School school;

    public Student(){

        System.out.println("无参构造被调用了");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
