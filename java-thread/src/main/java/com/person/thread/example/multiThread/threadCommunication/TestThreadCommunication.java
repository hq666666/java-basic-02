package com.person.thread.example.multiThread.threadCommunication;

import com.person.thread.example.multiThread.threadCommunication.handler.ConsumeHandler;
import com.person.thread.example.multiThread.threadCommunication.handler.ProduceHandler;
import com.person.thread.example.multiThread.threadCommunication.resource.Car;

/**
 * 需求： 实现生产者消费者模式：
 *           分析：生产者消费者，就需要共享的数据：
 *             1.创建共享数据；
 *             2.创建生产者；
 *             3.创建消费者；
 * @author  hq
 * @descriptino 测试多线程通讯：
 *
 */
public class TestThreadCommunication {

    public static void main(String[] args) {
        //-----多线程通信:synchronized+wait+notifyAll-------
        //共享资源
        //Car car = new Car();
        //Thread t1 = new Thread(new ProduceHandler(car));
        //Thread t2 = new Thread(new ConsumeHandler(car));
        //t1.start();
        //t2.start();
        //-----------多线程通信:lock+condition--------------
        //共享资源
        Car car = new Car();
        Thread t1 = new Thread(new ProduceHandler(car));
        Thread t2 = new Thread(new ConsumeHandler(car));
        t1.start();
        t2.start();
    }

}
