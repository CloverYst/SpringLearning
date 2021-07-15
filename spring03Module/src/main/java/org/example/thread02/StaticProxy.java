package org.example.thread02;

//静态代理模式总结：
//真实对象和代理对象都要实现同一个接口
//代理对象要代理真实对象
//好处： 代理对象可以做很多真实对象做不了的事情，真实对象可以专注于自己的事情
public class StaticProxy {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("love u");
            }
        }).start();
        //Thread是代理类代理了真实的Runnable接口
        new Thread( () -> System.out.println("I")).start();//Lamda表达式

//        WeddingCompany weddingCompany = new WeddingCompany(new You());
//        weddingCompany.HappyMarry();
        new WeddingCompany(new You()).HappyMarry();
    }
}
interface Marry{
    void HappyMarry();
}

class You implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("真实角色");
    }
}
class WeddingCompany implements Marry{
    private Marry target;

    public WeddingCompany(Marry target){
        this.target=target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void before() {
        System.out.println("前：布置现场");
    }

    private void after() {
        System.out.println("后：收尾款");
    }
}