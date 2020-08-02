/*
 *线程优先级1-10
 1.NORM_PRIORITY 5
 2.MIN_PRIORITY 1
 3.MAX_PRIORITY 10
 被调度的概率
 * */

public class PriorityTest {
    public static void main(String args[]) {
        System.out.println(Thread.currentThread().getPriority());
        MyPriority mp = new MyPriority();
        Thread t1 = new Thread(mp);
        Thread t2 = new Thread(mp);
        Thread t3 = new Thread(mp);

        //设置优先级在启动前
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
    }
}

class MyPriority implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
    }
}
