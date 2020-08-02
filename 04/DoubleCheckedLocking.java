/*单例模式：懒汉式套路基础上加入并发控制，保证在多线程环境下，对外只存在一个对象
 * 1.构造器私有化-->避免外部new构造器
 * 2.提供私有的静态属性-->存储对象的地址
 * 3.提供公有的静态方法-->获取属性
 *
 * */

public class DoubleCheckedLocking {
    //2.提供私有的静态属性
    private static volatile DoubleCheckedLocking instance;//没有volatile其他线程可能访问一个没来得及初始化的对象，请看第25行注释，由于指令重排的可能，可能导致步骤3比2先执行,所以用volatile

    // 1.构造器私有化
    private DoubleCheckedLocking() {

    }
    //3.提供公有的静态方法
    public static DoubleCheckedLocking getInstance() {
        //再次检测
        if (null != instance) {//避免不必要的同步，已经有对象了的话
            return instance;
        }
        synchronized(DoubleCheckedLocking.class) {//锁类的磨子
            if (null == instance) {
                instance = new DoubleCheckedLocking();//1.开辟空间 2.初始化对象信息 3.返回对象的地址给引用
            }
        }
        return instance;
    }

    public static void main(String args[]) {
        Thread t = new Thread(()->{
            System.out.println(DoubleCheckedLocking.getInstance());
        });
        t.start();
        System.out.println(DoubleCheckedLocking.getInstance());
    }
}
