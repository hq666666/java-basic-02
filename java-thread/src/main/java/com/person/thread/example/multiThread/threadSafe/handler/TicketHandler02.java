package com.person.thread.example.multiThread.threadSafe.handler;
/**
 * @author  hq
 * @descriptino 售票案例:
 *                解决线程安全问题：同步函数；
 */
public class TicketHandler02 implements Runnable {
    //票的总数(共享变量)
    private int count =100;

    @Override
    public void run() {
        while (count >0){

             show();
        }
    }

    /**
     * synchronized只适用于一个jvm;
     * synchronized同步函数：
     *     注意：只需要将会出现线程安全问题的代码包裹起来;
     */
    private synchronized void show()  {
        if(count>0){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"sell "+(100-count+1)+" ticket");
            count--;
        }
    }
}
