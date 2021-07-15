package org.example.threadstate;

public class TestDaemon {
    public static void main(String[] args) {
        God g = new God();
        You y = new You();

        //设置守护线程
        Thread thread = new Thread(g);
        thread.setDaemon(true);//默认是false是用户线程，一般都是

        thread.start();

        new Thread(y).start();//用户线程
    }
}
class God implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println("God bless you!");
        }
    }
}
class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("一生都很开心");
        }
        System.out.println("=========Goodbye World========");
    }
}