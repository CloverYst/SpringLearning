package org.example.threadstate;

import org.example.threadpractice.myThread4;

//模拟网络延时:放大问题的发生性
public class TestSleep implements Runnable{
    //票数
    private int ticketNumbers =10;

    @Override
    public void run() {
        while(true){
            if(ticketNumbers<=0)
                break;

            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->买到了票："+ticketNumbers--);
        }
    }

    public static void main(String[] args) {
        TestSleep ts = new TestSleep();

        new Thread(ts,"tom").start();
        new Thread(ts,"jerry").start();
        new Thread(ts,"mark").start();
    }
}
