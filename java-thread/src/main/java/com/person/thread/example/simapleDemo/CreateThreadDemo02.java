package com.person.thread.example.simapleDemo;

/**
 * @author  hq
 * @description 创建线程第二种方式实现Runnable接口
 */
public class CreateThreadDemo02 implements Runnable {

    @Override
    public void run() {
        for(int i=1;i<10;i++){
            System.out.println("create child thread implements,child thread loop execute task "+i);
        }
    }
}
