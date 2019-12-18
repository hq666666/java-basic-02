package com.person.thread.example.multiThread;

import com.person.thread.example.multiThread.entity.User;
import com.person.thread.example.multiThread.handler.ChildThread;
import com.person.thread.example.multiThread.util.PageUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  hq
 * @description 多线程分批处理数据
 */
public class BatchThread {

    public static void main(String[] args) {
        //1.初始化用户
        List<User> userList = initUser();
        //2.定义一个线程最多跑多少数据；
          int count = 20;
        //3.计算线程数，并且计算每个线程跑哪些数据；
        List<List<User>> pageInfo = PageUtil.getPageInfo(userList, count);
        for(int i=0;i<pageInfo.size();i++){
           // System.out.println("thread id"+i+"======"+pageInfo.get(i));
            //4.让子线程进行分批异步处理数据
            new Thread(new ChildThread(pageInfo.get(i))).start();
        }
    }

    private static List<User> initUser(){
        List<User> userList = new ArrayList<>();
        for(int i=0;i<105;i++){
             userList.add(new User("userId:"+i,"userName:"+i));
        }
        return  userList;
    }
}
