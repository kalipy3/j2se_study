/*
 *cpu和jvm编译器指令重排：代码执行顺序与预期不一致
 * */

public class HappenBefore {
    //变量1
    private static int a = 0;
    //变量2
    private static boolean flag = false;

    public static void main(String args[]) throws InterruptedException {
        for (int i = 0; i <99; i++) {
            a = 0;
            flag = false;
            //线程1 更改数据
            Thread t1 = new Thread(()->{
                a = 1;
                flag = true;
            });

            //线程2 读取数据
            Thread t2 = new Thread(()->{
                if (flag) {
                    a *= 1;
                }
                //指令重排
                if (a == 0) {
                    System.out.println("happen before->"+a);
                }
            });

            t1.start();
            t2.start();

            t1.join();
            t2.join();

        } 
    }
}
