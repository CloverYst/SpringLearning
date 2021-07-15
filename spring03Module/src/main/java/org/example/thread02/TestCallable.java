package org.example.thread02;

import org.apache.commons.io.FileUtils;
import org.example.threadpractice.myThread2;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

//线程创建方式三：实现Callable接口
//优点：可定义返回值；可以抛出异常
public class TestCallable implements Callable<Boolean> {

    private String url;//网络图片地址
    private String name;//保存的文件名

    public TestCallable(String url, String name){
        this.url=url;
        this.name=name;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.download(url,name);
        System.out.println("下载了文件名为"+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://imgcache.dealmoon.com/thumbimg.dealmoon.com/dealmoon/521/2d0/fa2/30e1679a22f096a6063b72a.jpg_800_0_3_3763.jpg","princess1.jpg");
        TestCallable t2 = new TestCallable("https://imgcache.dealmoon.com/thumbimg.dealmoon.com/dealmoon/119/e71/671/016bc2f7d0f5e5538f37837.jpg_800_0_3_f8da.jpg","princess2.jpg");
        TestCallable t3 = new TestCallable("https://imgcache.dealmoon.com/thumbimg.dealmoon.com/dealmoon/119/e71/671/016bc2f7d0f5e5538f37837.jpg_800_0_3_f8da.jpg","princess3.jpg");

        //创建执行服务： 创建一个线程池   两个类Executors 和ExecutorService
        ExecutorService ser= Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);
        //获取结果
        boolean res1 = r1.get();
        boolean res2 = r2.get();
        boolean res3 = r3.get();
        //关闭服务
        ser.shutdownNow();
    }

}

//下载器
class WebDownloader {
    //下载方法
    public void download(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO 异常，download方法出现问题");
        }
    }
}