package org.example.ba01;

import org.springframework.stereotype.Component;

/*
    component 表示创建对象，对象放在容器中，作用是<bean>
        属性：value，表示对象名称，也就是bean的id属性值
        位置：在类的上面，表示创建此类对象
    @Component(value = "myStudent") 等同于 <bean id="myStudent" class="org.example.ba01.Student" />
*/
@Component(value = "myStudent")
public class Student {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
