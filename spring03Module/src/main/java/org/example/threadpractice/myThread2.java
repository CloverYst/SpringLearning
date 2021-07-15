package org.example.threadpractice;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//练习Thread实现多线程同步下载图片
public class myThread2 extends Thread{

    private String url;//网络图片地址
    private String name;//保存的文件名

    public myThread2(String url, String name){
        this.url=url;
        this.name=name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.download(url,name);
        System.out.println("下载了文件名为"+name);
    }

    public static void main(String[] args) {
        myThread2 t1 = new myThread2("https://imgcache.dealmoon.com/thumbimg.dealmoon.com/dealmoon/521/2d0/fa2/30e1679a22f096a6063b72a.jpg_800_0_3_3763.jpg","princess1.jpg");
        myThread2 t2 = new myThread2("https://imgcache.dealmoon.com/thumbimg.dealmoon.com/dealmoon/119/e71/671/016bc2f7d0f5e5538f37837.jpg_800_0_3_f8da.jpg","princess2.jpg");
        myThread2 t3 = new myThread2("https://imgcache.dealmoon.com/thumbimg.dealmoon.com/dealmoon/119/e71/671/016bc2f7d0f5e5538f37837.jpg_800_0_3_f8da.jpg","princess3.jpg");

        t1.start();
        t2.start();
        t3.start();
    }
}

//下载器
class WebDownloader{
    //下载方法
    public void download(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO 异常，download方法出现问题");
        }
    }
}