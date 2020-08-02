/*
 *守护线程：为用户线程服务；jvm停止不用等待守护线程执行完毕
 用于后台日志和监控内存等。。

 默认：用户线程
 * */

public class DaemonThread {
    public static void main(String args[]) {
        God god = new God();
        You you = new You();
        Thread t = new Thread(god);
        t.setDaemon(true);
        t.start();
        new Thread(you).start();
    }
}

class You extends Thread {
    public void run() {
        for (int i = 1; i <= 365*100; i++) {
            System.out.println("happy life..");
        }
        System.out.println("ooooo..");
    }
}

class God extends Thread {
    public void run() {
        while (true) {
            System.out.println("bless you..");
        }
    }
}
