/*
 * extendThread.java
 * Copyright (C) 2020 android <android@localhost>
 *
 * Distributed under terms of the MIT license.
 *
 * 避免匿名内部类定义过多
 */

public class LambdaThread {
    //静态内部类
    static class Test implements Runnable {
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println("ttt1");
            }
        }
    }

  
    public static void main(String args[]) {
       new Thread(new Test()).start();

       //局部内部类
       class Test2 implements Runnable {
           public void run() {
               for (int i = 0; i < 20; i++) {
                   System.out.println("ttt2");
               }
           }
       }


       new Thread(new Test2()).start();

       //匿名内部类 必须借助接口或者父类
       new Thread(new Runnable() {
           public void run() {
               for (int i = 0; i < 20; i++) {
                   System.out.println("ttt3");
               }
           }
       }).start();
       
       //jdk8简化 lambda
       new Thread(()-> {
           for (int i = 0; i < 20; i++) {
               System.out.println("ttt4");
           }
       }).start();


    }
}

