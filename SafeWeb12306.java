
/*
 * SafeWeb12306.java
 * Copyright (C) 2020 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 *
 * 线程安全：
 * synchronized
 * 1.同步方法
 * 2.同步块
 * 
 * */


public class SafeWeb12306 implements Runnable
{
    private int ticketNums = 10;
    private boolean flag = true;
    
    public static void main(String args[]) {
        //一份资源
        SafeWeb12306 web = new SafeWeb12306();
        //多个代理
        new Thread(web,"t1").start(); 
        new Thread(web,"t2").start(); 
        new Thread(web,"t3").start(); 
    }


    public void run() {
        while (flag) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            test();
        }
    }

    //线程安全 同步方法 因为ticketNums和flag属于SafeWeb12306，因为锁的是this,所以锁的是第23行的web对象
    public synchronized void test() {
        if (ticketNums <= 0) {
            flag = false;
            return;
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);

    }

}

