package com.person.thread.example.multiThread.threadCommunication.resource;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hq
 * @description 共享资源
 */
public class Car {
    public String name;
    public String color;
    //标识flag：  false:没有货源需生产 true：有货源可以出售
   public boolean flag =false;
   //-------使用lock+conditon进行多线程通讯---------
    //实例化lock对象
    public Lock reentrantLock = new ReentrantLock();
    //实例化condition对象
    public Condition condition =  reentrantLock.newCondition();
    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
    //flag标识：false:没有货源需生产 true：有货源可以出售
    //public Boolean flag = false;
}
