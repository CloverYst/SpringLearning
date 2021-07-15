package org.example.thread02;

//推导Lamda表达式
public class TestLambda {
    //3.静态内部类
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("静态内部类");
        }
    }

    public static void main(String[] args) {
        ILike like =new Like();
        like.lambda();

        ILike like2 = new Like2();
        like2.lambda();

        //4. 局部内部类
         class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("局部内部类");
            }
        }

        ILike like3 = new Like3();
        like3.lambda();

        //5. 匿名内部类 没有类名称 借助接口或父类(重写方法)
        ILike like4 = new ILike() {
            @Override
            public void lambda() {
                System.out.println("匿名内部类");
            }
        };
        like4.lambda();

        //6. 用Lambda简化
        ILike like5 = () -> {
            System.out.println("Lambda 方式");
        };

    }
}

//1.定一个函数式接口
interface ILike{
    void lambda();
}

//2.外部实现类
class Like implements ILike{
    @Override
    public void lambda() {
        System.out.println("外部类");
    }
}
