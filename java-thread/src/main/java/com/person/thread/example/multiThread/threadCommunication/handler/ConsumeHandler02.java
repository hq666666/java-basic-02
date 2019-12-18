package com.person.thread.example.multiThread.threadCommunication.handler;

import com.person.thread.example.multiThread.threadCommunication.resource.Car;

/**
 * @author  hq
 * @description 消费者：使用lock+codition进行多线程通讯
 */
public class ConsumeHandler02  implements Runnable{
    //共享资源
    private Car car;

    public ConsumeHandler02(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        while (true){
            car.reentrantLock.lock();//加锁
            try {
                if(!car.flag){
                    try {
                        car.condition.await(); //线程等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                System.out.println("sell product "+car);
                car.flag = false; //没货源需生茶
                car.condition.signalAll(); //唤醒该lock对象的线程；
            } finally {
                car.reentrantLock.unlock(); //解锁
            }
        }
    }
}
