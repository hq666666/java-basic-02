package com.person.designPattern.signleton;

/**
 * @author  hq
 * @description 饿汉式单例模式：
 *                多线程下安全，因为类的实例化通过jvm加载是已实例化
 */
public class Signleton {

    private static Signleton instance = new Signleton();

    private Signleton(){}

    public static Signleton getInstance(){
      return instance;
    }

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(Signleton.getInstance().toString());
            }).start();
        }

    }
}
