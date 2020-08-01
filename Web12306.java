
/*
 * Web12306.java
 * Copyright (C) 2020 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class Web12306 implements Runnable
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
        Web12306 web = new Web12306();
        //多个代理
        new Thread(web,"t1").start(); 
        new Thread(web,"t2").start(); 
        new Thread(web,"t3").start(); 
    }
}

