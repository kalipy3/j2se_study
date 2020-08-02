
/*
 * SafeWeb12306.java
 * Copyright (C) 2020 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 *
 * 线程安全：
 * synchronized
 * 2.同步块
 * 
 * */


public class SynBlockTest03 implements Runnable
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

           //test();//ok
            //test3();//fail
            //test4();//fail
            test5();
        }
    }

    //线程安全 范围太大-->效率底下
    public void test() {
        synchronized(this) {//SafeWeb12306 
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

    //线程不安全，没锁对,ticketNums对象一直在变,一个锁地址不变的东西
    public void test3() {
        synchronized((Integer)ticketNums) {
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

    //线程不安全 范围太小锁不住 t1 t2 t3 可以同时进到89行
    public void test4() {
        synchronized(this) {
            if (ticketNums <= 0) {
                flag = false;
                return;
            }
        }
        try {
            Thread.sleep(200);//89行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);


    }
    //线程安全：尽可能锁定合理范围
    //double checking
    public void test5() {
        if (ticketNums <= 0) {//考虑的是没有票的情况
            flag = false;
            return;
        }
        synchronized(this) {//SafeWeb12306 
            if (ticketNums <= 0) {//考虑追后一张票
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


}

