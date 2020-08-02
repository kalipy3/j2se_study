/*
 *线程不安全：操作容器
 size比预期小，即有的被覆盖了
 * */
import java.util.ArrayList;
import java.util.List;

public class UnsafeTest03 {
    public static void main(String args[]) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        System.out.println(list.size());
    }
}
