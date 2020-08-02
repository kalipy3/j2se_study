import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest01 {
    public static void main(String args[]) {
        Timer timer = new Timer();
        //执行安排
        //timer.schedule(new MyTask(),5000);//5秒后执行任务一次
        //timer.schedule(new MyTask(),5000, 200);//5秒后执行任务,每隔200ms一直执行
        
        Calendar cal = new GregorianCalendar(2099, 12, 31, 21, 53, 54);
        timer.schedule(new MyTask(), cal.getTime(), 200);//指定时间
    }
}

//任务类
class MyTask extends TimerTask {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("task..");
        }
        System.out.println("------------end-------");
    }
}
