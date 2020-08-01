/*
 * YieldDemo01.java
 * Copyright (C) 2020 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 *
 * yield礼让线程，暂停线程 直接从运行态进入就绪状态不是阻塞状态
 */

public class YieldDemo01
{
	public static void main(String args[]) {
	    MyYield my = new MyYield();
        new Thread(my,"a").start();
        new Thread(my,"b").start();
	}
}

class MyYield implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->start");
        Thread.yield();//礼让
        System.out.println(Thread.currentThread().getName()+"-->end");
    }
}

