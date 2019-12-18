package com.person.thread.example.multiThread.threadSafe;

import com.person.thread.example.multiThread.threadSafe.handler.TicketHandler02;
import com.person.thread.example.multiThread.threadSafe.handler.TicketHandler03;

/**
 * @author hq
 * @descriptino 测试多线程导致数据安全问题
 */
public class TestThreadSafe {

    public static void main(String[] args) {
        //-----------synchronized同步代码块-----------
        //使多个线程共享同一个变量
        //TicketHandler ticketHandler = new TicketHandler();
        //Thread t1 = new Thread(ticketHandler);
        //Thread t2 = new Thread(ticketHandler);
        //t1.start();
        //t2.start();

        //-----------synchronized同步函数-----------
        //使多个线程共享同一个变量
        //TicketHandler02 ticketHandler = new TicketHandler02();
        //Thread t1 = new Thread(ticketHandler);
        //Thread t2 = new Thread(ticketHandler);
        //t1.start();
        //t2.start();

        //-----------synchronized静态同步代码块-----------
        //使多个线程不同对象共享同一个静态变量
        TicketHandler03 ticketHandler01 = new TicketHandler03();
        TicketHandler03 ticketHandler02 = new TicketHandler03();
        Thread t1 = new Thread(ticketHandler01);
        Thread t2 = new Thread(ticketHandler02);
        t1.start();
        t2.start();

    }
}
