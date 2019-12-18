package com.person.thread.example.multiThread.handler;

import com.person.thread.example.multiThread.entity.User;

import java.util.List;

/**
 * @author  hq
 * @description 真正处理数据的线程
 */
public class ChildThread implements  Runnable {
    //分批处理的数据
    private List<User> userList;

    public ChildThread(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public void run() {
         for(User user:userList){
             try {
                 Thread.sleep(500);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             System.out.println(Thread.currentThread().getName()+"executor task:"+user);
         }
    }
}
