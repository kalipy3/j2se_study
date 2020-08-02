import java.util.ArrayList;
import java.util.List;

public class SynBlockTest02 {
    public static void main(String args[]) throws InterruptedException {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                synchronized(list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        Thread.sleep(5000);//让main等一下，不然10行线程没执行完，15行就执行了
        System.out.println(list.size());
    }
}
