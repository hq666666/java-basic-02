package com.person.thread.example.simapleDemo;

/**
 * @author  hq
 * @description 创建线程第一种方式继承thread
 */
public class CreateThreadDemo01 extends Thread {

    /**
     * @description run执行任务的方法
     */
    @Override
    public void run() {
        for(int i=1;i<10;i++){
            System.out.println("create child thread extends thread ,child thread loop execute task"+i);
        }
    }
}
