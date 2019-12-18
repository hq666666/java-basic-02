package com.person.thread.example.multiThread.threadCommunication.handler;

import com.person.thread.example.multiThread.threadCommunication.resource.Car;

/**
 * @author  hq
 * @description 生产者：使用lock+codition进行多线程通讯
 */
public class ProduceHandler02 implements  Runnable {
    //共享资源
    private Car car;

    public ProduceHandler02(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        int count =0;
        while (true){
            car.reentrantLock.lock();//加锁
            try {
                if(car.flag){
                    try {
                        car.condition.await(); //线程等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                if(count == 0){
                    car.name = "audi";
                    car.color = "red";
                }else {
                    car.name ="baoma";
                    car.color ="white";
                }
                count = (count+1)%2; //实现奇偶数生产不同产品
                car.flag = true; //有货源可以出售
                car.condition.signalAll(); //唤醒该lock对象的线程；
            } finally {
                car.reentrantLock.unlock(); //解锁
            }
        }
    }
}
