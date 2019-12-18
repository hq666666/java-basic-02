package com.person.thread.example.multiThread.threadCommunication.handler;

import com.person.thread.example.multiThread.threadCommunication.resource.Car;

/**
 * @author hq
 * @description 消费者
 */
public class ConsumeHandler implements Runnable {
    //共享资源
    private Car car;

    public ConsumeHandler(Car car) {
        this.car = car;
    }


    @Override
    public void run() {
     while (true){
         synchronized (car){
             if(!car.flag){
                 try {
                     car.wait();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
             System.out.println("sell product "+car);
             car.flag = false; //通知需生产
             car.notifyAll(); //唤醒等待线程
         }
     }
    }
}
