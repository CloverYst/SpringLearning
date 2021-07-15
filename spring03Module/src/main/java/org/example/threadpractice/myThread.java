package org.example.threadpractice;

//创建线程方式1：继承thread类

//总结：注意，线程开启不一定立即执行，由cpu调度执行
public class myThread extends Thread{
    @Override
    public void run() {
        //run方法线程体
        for(int i=0;i<10;i++)
        System.out.println("线程"+i);
    }
    public static void main(String[] args) {
        //main线程，主线程

        //创建一个线程对象调用start方法开启线程
        myThread myThread1 = new myThread();
        myThread1.start();


        for (int i = 0; i < 10; i++) {
            System.out.println("主线程"+i);
        }

    }
}
