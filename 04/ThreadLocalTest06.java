/*
 *InheritableThreadLocal:继承上下文环境的数据 把数据copy一份给子线程(不是直接共享
 * */

public class ThreadLocalTest06 {
    private static ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();
    public static void main(String args[]) {
        threadLocal.set(2);
        System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
            threadLocal.set(200);
            System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
        }).start();
    }
}
