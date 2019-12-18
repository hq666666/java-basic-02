package com.person.thread.example.multiThread.threadSafe.lock;

import com.person.thread.example.multiThread.threadSafe.lock.handler.LockExample;

/**
 * @author hq
 * @description 测试死锁
 */
public class TestLock {

    public static void main(String[] args) throws InterruptedException {

        LockExample lockExample = new LockExample();
        Thread t1 = new Thread(lockExample);
        Thread t2 = new Thread(lockExample);
        //这是一个技巧：flag默认为true，先让一个线程执行flag为true的代码；
        t1.start();
        Thread.sleep(100);
        //在设置表示为flag为false，让一个线程执行flag为false的代码，这是就大概率可以模拟出死锁的情况
        lockExample.flag = false;
        t2.start();
    }
}
