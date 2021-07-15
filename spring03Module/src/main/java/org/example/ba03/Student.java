package org.example.ba03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "myStudent")
public class Student {
    /**
     * 简单类型的属性赋值：@Value
     *      属性：value 简单类型属性值
     *      位置 1）在属性定义的上面，无需set方法，推荐使用 2）在set方法上面
     */
    @Value("${myname}")
    private String name;
    @Value("${myage}")
    private int age;

    /**
    * 引用类型
    * @Autowired: Spring 提供的给引用类型赋值的，使用自动注入原理
     *      支持byName byType(默认)
     *      使用位置： 1）属性的定义的上面，无需set方法，推荐使用 2）在set方法上面
     * */

    //默认使用byType
    @Autowired
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
