
/*
 * YieldDemo01.java
 * Copyright (C) 2020 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 *
 * yield礼让线程，暂停线程 直接从运行态进入就绪状态不是阻塞状态
 */

public class YieldDemo02
{
	public static void main(String args[]) {
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("lambda.."+i);
            }
        }).start();
        
        for (int i = 0; i < 100; i++) {
            if (i%20 == 0) {
                Thread.yield();//main礼让
            }
            System.out.println("main.."+i);
        }

    }
}


