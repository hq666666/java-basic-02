package com.person.thread.example.multiThread.threadSafe.handler;

/**
 * @author  hq
 * @descriptino 售票案例:
 *                解决线程安全问题：同步代码块；
 */
public class TicketHandler implements Runnable {
    //票的总数(共享变量)
    private int count =100;

    @Override
    public void run() {
        //synchronized (this){ 这样做就变成了单线程；
        while(count >0){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //--------解决线程安全问题---------
            /**
             * synchronized只适用于一个jvm;
             * synchronized同步代码块：
             *     注意：只需要将会出现线程安全问题的代码包裹起来，扩大synchronized锁的粒度的话可能会变成单线程执行；
             */
            synchronized (this){
                if(count >0){
                    System.out.println(Thread.currentThread().getName()+"sell "+(100-count+1)+" ticket");
                    count--;
                }
            }
        }
    }
}
