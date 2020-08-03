/*
 *ThreadLocal:分析上下文 环境
 1.看构造器：哪里调用 就属于哪里
 * */

public class ThreadLocalTest05 {
       //更改初始值方式2
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->{
        return 1;
    });
    public static void main(String args[]) {
        new Thread(new MyRun()).start();
        new Thread(new MyRun()).start();
    }

    public static class MyRun implements Runnable {
        public MyRun() {//属于main线程 因为MyRun是由main方法new的
            threadLocal.set(-100);
            System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
        }
        public void run() {//这个才是子线程的 run()属于子线程
            System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
        }
    }
}
