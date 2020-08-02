import  java.lang.Thread.State;

/*
 * ThreadState.java
 * Copyright (C) 2020 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 *
 * 观察线程的状态
 */

public class ThreadState
{
	public static void main(String args[]) {
        Thread t = new Thread(()->{
            System.out.println("...");
        });
        //观察状态
        State state = t.getState();
        System.out.println(state);//new

        t.start();
        state = t.getState();
        System.out.println(state);//runnable
    }
}

