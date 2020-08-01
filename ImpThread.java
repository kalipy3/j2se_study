/*
 * extendThread.java
 * Copyright (C) 2020 android <android@localhost>
 *
 * Distributed under terms of the MIT license.
 */

public class ImpThread implements Runnable
{
    public void run() {
        System.out.println("t111");
    }

    public static void main(String args[]) {
       ImpThread t = new ImpThread();
       new Thread(t).start();
       System.out.println("mmmm");
    }
}

