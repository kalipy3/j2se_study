
/*
 * BlockedSleep01.java
 * Copyright (C) 2020 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 *
 * sleep模拟网络时延，放大问题可能
 *
 * sleep:
 * 阻塞当前线程
 * sleep可以模拟网络延时，倒计时等
 * sleep时间到达后线程进入就绪状态
 * 每一个对象都有一个锁，sleep不会释放锁
 */

public class BlockedSleep01 implements Runnable
{
    private int ticketNums = 99;

    public void run() {
        while (true) {
            if (ticketNums < 0) {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
        }
    }

    public static void main(String args[]) {
        System.out.println("mmmm");
        //一份资源
        BlockedSleep01 web = new BlockedSleep01();
        //多个代理
        new Thread(web,"t1").start(); 
        new Thread(web,"t2").start(); 
        new Thread(web,"t3").start(); 
    }
}

