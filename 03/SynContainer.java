/*
 *线程安全：操作并发容器
 *
 * */

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.ArrayList;
import java.util.List;

public class SynContainer {
    public static void main(String args[]) throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                    list.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(5000);//让main等一下，不然10行线程没执行完，15行就执行了
        System.out.println(list.size());
    }
}
