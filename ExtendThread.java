/*
 * extendThread.java
 * Copyright (C) 2020 android <android@localhost>
 *
 * Distributed under terms of the MIT license.
 */

public class ExtendThread extends Thread
{
    public void run() {
        System.out.println("t111");
    }

    public static void main(String args[]) {
       ExtendThread t = new ExtendThread();
       t.start();
       System.out.println("mmmm");
    }
}

