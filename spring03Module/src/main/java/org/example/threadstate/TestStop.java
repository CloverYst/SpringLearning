package org.example.threadstate;

//测试stop线程
//1。线程自动停止：利用次数不建议死循环
//2。设置一个标志位 flag
//3。不要使用stop（） destroy（）方法
public class TestStop implements Runnable{
    //设置一个标示
    private boolean flag = true;

    @Override
    public void run() {
        int i=0;
        while(flag){
            System.out.println("run ... Thread"+i++);
        }
    }

    //2.设置一个公开的方法停止线程，转换标示位
    public void stop(){
        this.flag=false;
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main"+i);
            if(i==900) {
                testStop.stop();
                System.out.println("线程停止了。。");
            }
        }
    }
}
