package org.example.ba01;

public class Student {
    private String name;
    private int age;

    public Student() {
        System.out.println("student的无参构造方法");
    }
    public String getName() {

        return name;
    }

    public void setName(String name) {
        System.out.println("set name"+name);
        this.name = name;

    }

    public int getAge() {
        return age;
    }



    public void setAge(int age) {
        System.out.println("set name"+age);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
