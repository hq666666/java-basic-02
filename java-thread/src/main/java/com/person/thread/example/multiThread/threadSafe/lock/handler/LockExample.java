package com.person.thread.example.multiThread.threadSafe.lock.handler;

/**
 * @author hq
 * @description 死锁示例 ：
 *                  前提：需要两把锁，以及需声明一个标识，使多个线程执行不同的代码；
 */
public class LockExample implements Runnable {

    private int count = 100;
    private Object object = new Object();
    public Boolean flag = true;
    @Override
    public void run() {
      if(flag){
          while (count>0){
              synchronized (object){ //第一把锁
                  show();
              }
          }
      } else {
          while (count >0){
              show();
          }
      }
    }

    private synchronized void show() { //第二把锁(this)
        synchronized (object){
           if(count >0){
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
}
