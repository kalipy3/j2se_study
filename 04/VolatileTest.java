/*
 *volatile用于保证数据的同步，也就是可见性

 1.可见性：
 a)线程对变量进行修改之后，要立刻回写到主存
 b)线程对变量读取的时候，要从主存中读，而不是线程的工作内存

 注意：
 volatile不能保证原子性
 现在cpu快，volatile用的不多了

 * */
public class VolatileTest {
    private volatile static int num = 0;
    //private static int num = 0;
    public static void main(String args[]) throws InterruptedException {
        new Thread(()->{
            while (num == 0) {//此处不要写代码,让cpu没时间同步

            }
        }).start();

        Thread.sleep(1000);
        num = 1;//使用15行代码，理论上1s后线程应该停止，但是却死循环，解决：加volatile关键字
    }
}
