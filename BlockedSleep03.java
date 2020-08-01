import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * extendThread.java
 * Copyright (C) 2020 android <android@localhost>
 *
 * Distributed under terms of the MIT license.
 *
 * sleep模拟倒计时
 */

public class BlockedSleep03
{
    public static void test() throws InterruptedException {

        //倒数10个数，1秒一个
        int num = 10;
        while (true) {
            Thread.sleep(1000);
            System.out.println(num--);
        }
    }

    public static void main(String args[]) throws InterruptedException {
        //test();

        //倒计时
        Date endTime = new Date(System.currentTimeMillis()+1000*10); 
        while (true) {
            System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
            Thread.sleep(1000);
            endTime = new Date(endTime.getTime()-1000);
        }
    }
}

