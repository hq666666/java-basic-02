package com.person.thread.example.multiThread.threadSafe.handler;
/**
 * @author  hq
 * @descriptino 售票案例:
 *                解决线程安全问题：静态同步函数；
 */
public class TicketHandler03 implements Runnable{

    //票的总数(静态共享变量)
    private  static int count =100;

    @Override
    public void run() {
        while(count >0){
            //--------解决线程安全问题---------
            /**
             * synchronized只适用于一个jvm;
             * synchronized静态同步代码块：
             *     注意：只需要将会出现线程安全问题的代码包裹起来，扩大synchronized锁的粒度的话可能会变成单线程执行；；
             */
            synchronized (TicketHandler03.class){
                if(count >0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"sell "+(100-count+1)+" ticket");
                    count--;
                }
            }
        }
    }
}
