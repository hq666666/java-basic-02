package com.person.thread.example.multiThread.interviewQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author hq
 * @question : 面试问题： 实现一个容器的有add()、size(),一个线程向容器中添加10个数，另一个线程监控，当容器有5个数就进行提示；
 *              分析：
 *                 技术要点：
 *                        多线程的可见性
 *                        多线程的通讯；通过CountDownLatch(门闩)，当CountDownLatch为0是就会释放该门闩；
 */
public class interviewQuestions02 {

    public static void main(String[] args) throws InterruptedException {
        NewContainer02 c = new NewContainer02();
        CountDownLatch latch = new CountDownLatch(1);
        new Thread(()->{
            System.out.println("t2 start ");
           if(c.size() != 5){
               try {
                   latch.await(); //上门闩；
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
            System.out.println("t2 is know");
        },"t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            System.out.println("t1 start");
           for (int i=1;i<=10;i++){
               c.add(new Object());
               if(c.size() == 5){
                   latch.countDown(); //当CountDownLatch会释放门闩；
               }
               System.out.println("t2 add "+i);
           }
        },"t1").start();
    }
}
class NewContainer02{

    //使用volatile保证多线程数据的可见性
    volatile List list = new ArrayList();

    public void add (Object i){
        list.add(i);
    }
    public int size(){
        return list.size();
    }
}
