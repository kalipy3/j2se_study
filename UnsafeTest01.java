
/*
 * UnsafeTest01.java
 * Copyright (C) 2020 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 *
 * 线程不安全：数据有负数和相同票数的情况
 * 负数是因为线程”同时“进到run方法去了
 * 相同是因为每个线程的各自的工作空间与主存的数据复制
 * */

public class UnsafeTest01 implements Runnable
{
    private int ticketNums = 10;
    private boolean flag = true;

    public void run() {
        while (flag) {
            test();
        }
    }

    public void test() {
        if (ticketNums < 0) {
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

    public static void main(String args[]) {
        //一份资源
        UnsafeTest01 web = new UnsafeTest01();
        //多个代理
        new Thread(web,"t1").start(); 
        new Thread(web,"t2").start(); 
        new Thread(web,"t3").start(); 
    }
}

