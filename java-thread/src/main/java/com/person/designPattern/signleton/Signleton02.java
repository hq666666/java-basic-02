package com.person.designPattern.signleton;


/**
 * @author  hq
 * @description 懒汉式单例模式：双重检查机制
 *
 *
 */
public class Signleton02 {

    /**
     * 为什么需要添加volatile：
     *     01：不添加可能会出现的问题：
     *           由于对象的初始化分两步：
     *              第一步：赋默认值
     *              第二步：赋初始化的值
     *              最后返回结果(但jvm中在不影响最后的结果可以使用指令重排序)；
     *              导致的问题：
     *                  可能初始化一般，只做了第一步，其他线程操作了该对象，那返回的对象的数据就不正确了；
     *    02：volatile的作用:
     *         01:多线程之间可见性；
     *         02：禁止指令重排序；
     */
    private static volatile Signleton02 instance;

    private Signleton02(){}

    public static Signleton02 getInstance(){
        if(null == instance){
            synchronized (Signleton.class){
              if(null == instance){
                  try {
                      Thread.sleep(10);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  instance = new Signleton02();
              }
            }
        }
     return instance;
    }

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(Signleton02.getInstance().toString());
            }).start();
        }
    }
}
