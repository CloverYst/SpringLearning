package org.example.ba03;

public class Student {
    private String name;
    private int age;

    //引用类型
    private School school;

    public Student() {

        System.out.println("student的无参构造方法");
    }

    public Student(String myname, int myage, School myschool){
        System.out.println("student的有参构造方法");
        this.name=myname;
        this.age=myage;
        this.school=myschool;
    }

    public void setName(String name) {
        System.out.println("set name"+name);
        this.name = name;

    }

    public void setAge(int age) {
        System.out.println("set name"+age);
        this.age = age;
    }

    public void setSchool(School school) {
        System.out.println("set school"+school);
        this.school = school;
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
