package com.person.thread.example.multiThread.interviewQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author hq
 * @question : 面试问题： 实现一个容器的有add()、size(),一个线程向容器中添加10个数，另一个线程监控，当容器有5个数就进行提示；
 *              分析：
 *                 技术要点：
 *                        多线程的可见性
 *                        多线程的通讯；
 */
public class interviewQuestions01 {

    public static void main(String[] args) throws InterruptedException {
        NewContainer c = new NewContainer();
        final Object o = new Object();
      new Thread(()->{
               synchronized (o){
                   System.out.println("t2 "+"start");
                   if(c.size() != 5){
                       try {
                           o.wait();
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
                   System.out.println(Thread.currentThread().getName()+" is know");
                   o.notify();
               }

        },"t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            System.out.println("t1"+"start");
           for(int i=1;i<=10;i++){
             synchronized (o){
                 if(c.size() == 5){
                     o.notify(); //注意唤醒等待线程不会释放锁，导致需在整个线程执行完才能执行t2线程
                     try {
                         o.wait(); //通过wait方法是当前线程释放锁
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
                 c.add(new Object());
                 System.out.println("t1 add "+i);
             }
           }
        },"t1").start();
    }
}
class NewContainer{

    //使用volatile保证多线程数据的可见性
    volatile List list = new ArrayList();

    public void add (Object i){
        list.add(i);
    }
    public int size(){
        return list.size();
    }
}
