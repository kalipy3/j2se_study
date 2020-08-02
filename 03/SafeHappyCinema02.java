import java.util.ArrayList;
import java.util.List;

public class SafeHappyCinema02 {
    public static void main(String args[]) {

        //可用位置
        List<Integer> available = new ArrayList<Integer>();
        available.add(1);
        available.add(2);
        available.add(3);
        available.add(6);
        available.add(7);

        //顾客需要的位置
        List<Integer> seats1 = new ArrayList<Integer>();
        seats1.add(1);
        seats1.add(2);

        List<Integer> seats2 = new ArrayList<Integer>();
        seats2.add(4);
        seats2.add(5);
        seats2.add(6);


        Cinema c = new Cinema(available, "happy sxt");
        new Thread(new HappyCustomer(c, seats1), "t1").start();
        new Thread(new HappyCustomer(c, seats2), "t2").start();
    }
}

//顾客 
class HappyCustomer implements Runnable {
    Cinema cinema;
    List<Integer> seats;

    public HappyCustomer(Cinema cinema, List<Integer> seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    public void run() {
        synchronized(cinema) {
            boolean flag = cinema.bookTickets(seats);
            if (flag) {
                System.out.println("出票成功"+Thread.currentThread().getName()+"-<位置为："+seats);
            } else {
                System.out.println("出票失败"+Thread.currentThread().getName()+"-<位置不够");
            }
        }
    }
}

//影院
class Cinema {
    List<Integer> available;//可用的位置
    String name;
    public Cinema(List<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }
    //购票
    public boolean bookTickets(List<Integer> seats) {
        System.out.println("可用位置为："+available);
        List<Integer> copy = new ArrayList<Integer>();
        copy.addAll(available);
        //相减
        copy.removeAll(seats);
        //判断大小
        if (available.size()-copy.size() != seats.size()) {
            return false;
        }
        //成功
        available = copy;
        return true;
    }
}

