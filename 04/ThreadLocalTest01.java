public class ThreadLocalTest01 {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    public static void main(String args[]) {
        System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
    }
}
