/*
 *ThreadLocal:每个线程存储自己的数据，更改不会影响其他线程
 * */

public class ThreadLocalTest04 {
       //更改初始值方式2
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->{
        return 1;
    });
    public static void main(String args[]) {
        for (int i = 0; i < 5; i++) {
            new Thread(new MyRun()).start();
        }
        
    }

    public static class MyRun implements Runnable {
        public void run() {
            Integer left =  threadLocal.get();
            System.out.println(Thread.currentThread().getName()+"得到了-->"+threadLocal.get());
            //设置值
            threadLocal.set(left-1);
            System.out.println(Thread.currentThread().getName()+"还剩下-->"+threadLocal.get());
        }
    }
}
