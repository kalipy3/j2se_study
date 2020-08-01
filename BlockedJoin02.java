
/*
 * YieldDemo01.java
 * Copyright (C) 2020 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 *
 * join:合并线程 插队线程
 * 当前线程执行完后，再执行其他线程，其他线程阻塞
 */

public class BlockedJoin02
{
    public static void main(String args[]) throws InterruptedException {
        System.out.println("father和son买烟的故事");
        new Thread(new Father()).start();
    }
}

class Father extends Thread {
    public void run() {
        System.out.println("想抽烟，发现没了");
        System.out.println("让son去买中华");
        Thread t = new Thread(new Son());
        t.start();

        try {
            t.join();//father被阻塞
            System.out.println("father接过烟，把零钱给了son");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("孩子走丢了，father去找孩子了。。");

        }

    }
}


class Son extends Thread {
    public void run() {
        System.out.println("接过老爸的钱出去了。。");
        System.out.println("路边有个游戏厅，玩了10s");
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(i+"秒过去了。。");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("赶紧买烟去。。");
        System.out.println("手拿一包中华回家了。。");

    }
}
