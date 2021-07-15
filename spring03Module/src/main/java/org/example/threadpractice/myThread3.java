package org.example.threadpractice;

//创建线程方法2 实现runnable接口，重写run方法，执行线程需要放入runnable接口实现类，调用start
public class myThread3 implements Runnable{
    @Override
    public void run() {
        //run方法线程体
        for(int i=0;i<10;i++)
            System.out.println("线程"+i);
    }
    public static void main(String[] args) {
        //main线程，主线程

        //创建一个Runnable接口的实现类对象
        myThread3 t = new myThread3();

        //创建一个线程对象，通过线程对象来开启线程，代理
//        Thread thread = new Thread(t);
//
//        thread.start();
        new Thread(t).start();


        for (int i = 0; i < 10; i++) {
            System.out.println("主线程"+i);
        }

    }
}
