package org.example.threadstate;

public class TestState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("///////");
        });

        //观察状态
        Thread.State state = thread.getState();
        System.out.println(state);//NEW

        //观察启动后
        thread.start();
        state=thread.getState();
        System.out.println(thread);//RUNNABLE

        while(state!=Thread.State.TERMINATED){//只要线程不终止就一直输出状态
            Thread.sleep(100);
            state=thread.getState();//更新线程状态
            System.out.println(state);
        }
    }
}