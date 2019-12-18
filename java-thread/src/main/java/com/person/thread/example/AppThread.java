package com.person.thread.example;
import com.person.thread.example.simapleDemo.CreateThreadDemo02;


/**
 * @author  hq
 * @description 线程main线程
 */
public class AppThread {

    public static void main(String[] args) {

        System.out.println("thread start ");
        //创建线程第一种方式继承thread
        /*CreateThreadDemo01 threadDemo01 = new CreateThreadDemo01();
        threadDemo01.start();*/
        //创建第二种方式实现Runnable
        Thread t1 = new Thread(new CreateThreadDemo02());
        t1.start();
        for(int i=1;i<10;i++){
            System.out.println("mian thread executor task:"+i);
        }
    }
}
