import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class CallRacer implements Callable<Integer> {
    private static String winner;

    public Integer call() throws Exception {
        for (int steps = 1; steps <= 100; steps++) {
            if (Thread.currentThread().getName().equals("rabbit") && steps%10==0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName()+"-->"+steps);
            boolean flag = gameOver(steps);
            if (flag) {
                return steps;
            }
        }
        return null;
    }

    private boolean gameOver(int steps) {
        if (winner != null) {
            return true;
        } else {
            if (steps == 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winner==>"+winner);
                return true;
            }
        }

        return false;
    }

    public static void main(String args[]) throws Exception {
        CallRacer racer = new CallRacer();
        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(2);
        //提交执行
        Future<Integer> result1 = ser.submit(racer);
        Future<Integer> result2 = ser.submit(racer);

        //获取结果
        Integer r1 = result1.get();
        Integer r2 = result2.get();
        System.out.println(r2);

        //关闭服务
        ser.shutdownNow();
    }
}
