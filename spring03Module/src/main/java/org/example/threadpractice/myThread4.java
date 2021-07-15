package org.example.threadpractice;

//多个线程同时操作同一个对象
//买火车票的例子

public class myThread4 implements Runnable{
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
        myThread4 t = new myThread4();

        new Thread(t,"tom").start();
        new Thread(t,"jerry").start();
        new Thread(t,"mark").start();
    }
}
