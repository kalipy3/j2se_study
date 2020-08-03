public class ThreadLocalTest02 {
    //更改初始值方式1
   /* private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>() {
        @Override
        protected Integer initialValue() {
            return 200;
        }
    };*/
    //更改初始值方式2
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->{
        return 300;
    });
    public static void main(String args[]) {
        System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
        //设置值
        threadLocal.set(99);
        System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
        
    }
}
