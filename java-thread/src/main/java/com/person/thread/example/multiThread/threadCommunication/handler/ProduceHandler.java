package com.person.thread.example.multiThread.threadCommunication.handler;

import com.person.thread.example.multiThread.threadCommunication.resource.Car;

/**
 * @author hq
 * @descriptino 生产者
 */
public class ProduceHandler implements Runnable {
    //共享资源
    private Car car;

    public ProduceHandler(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
       int count = 0;
       while (true){
           synchronized (car){
               if(car.flag){
                   try {
                       //wait让当前线程从执行状态编程等待状态(即阻塞状态)
                       //wait 需要和synchronized一起使用
                       car.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
               if(count ==0){
                   car.name = "audi";
                   car.color = "red";
               }else {
                   car.name = "baoma";
                   car.color = "white";
               }
               //实现奇偶数生产不同产品
               count = (count+1)%2;
               car.flag = true; //标识有货源可以出售
               car.notifyAll(); //唤醒该锁对象的等待线程；
           }
       }


    }


}
