package org.example.threadstate;

public class TestJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("VIP 来了"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //启动自己写的线程
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        //主线程
        for (int i = 0; i < 10; i++) {
            if(i==7){
                thread.join();
            }
            System.out.println("main"+i);
        }
    }
}
