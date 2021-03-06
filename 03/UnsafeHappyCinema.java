//线程不安全，出现相同可用位置
public class UnsafeHappyCinema {
    public static void main(String args[]) {
        Cinema c = new Cinema(20, "happy sxt");
        new Thread(new Customer(c, 2), "t1").start();
        new Thread(new Customer(c, 1), "t2").start();
    }
}

//顾客 
class Customer implements Runnable {
    Cinema cinema;
    int seats;

    public Customer(Cinema cinema, int seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    public void run() {
        boolean flag = cinema.bookTickets(seats);
        if (flag) {
            System.out.println("出票成功"+Thread.currentThread().getName()+"-<位置为："+seats);
        } else {
            System.out.println("出票失败"+Thread.currentThread().getName()+"-<位置不够");
        }
    }
}

//影院
class Cinema {
    int available;//可用的位置
    String name;
    public Cinema(int available, String name) {
        this.available = available;
        this.name = name;
    }
    //购票
    public boolean bookTickets(int seats) {
        System.out.println("可用位置为："+available);
        if (seats > available) {
            return false;
        }
        available -= seats;
        return true;
    }
}

