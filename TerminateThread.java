
/*
 * TerminateThread.java
 * Copyright (C) 2020 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 * 终止线程
 * 1.线程正常执行完毕-->次数
 * 2.外部干涩-->加入flag标识
 * 不要使用废弃的stop destroy
 */

public class TerminateThread implements Runnable
{   
    private boolean flag = true;
    private String name;

    public TerminateThread(String name) {
        super();
        this.name = name;
    }

	public static void main(String args[]) {
		TerminateThread tt = new TerminateThread("t");
        new Thread(tt).start();

        for (int i = 0; i <= 99; i++) {
            if (i == 88) {
                tt.terminate();//线程的终止
                System.out.println("tt game over");
            }
            System.out.println("main-->"+i);
        }
	}

    public void run() {
        int i = 0;
        while (flag) {
            System.out.println(name+"-->"+i++);
        }

    }
    public void terminate() {
        this.flag = false;
    }
}

