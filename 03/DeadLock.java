/*
 *死锁：过多的同步可能造成互相不释放资源
 从而相互等待，一般发生于同步持有多个对象的锁
 * */
public class DeadLock {
    public static void main(String args[]) {
        Markup g1 = new Markup(1, "t1");
        Markup g2 = new Markup(0, "t2");
        g1.start();
        g2.start();
    }
}

//口红
class Lipstick {

}

//镜子
class Mirror {

}

//化妆
class Markup extends Thread {
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;
    //名字
    String girl;

    public Markup(int choice, String girl) {
        this.choice = choice;
        this.girl = girl;
    }

    public void run() {
        //化妆
        markup();
    }

    //互相持有对方的对象锁-->可能造成死锁
    private void markup() {
        if (choice == 0) {
            synchronized(lipstick) {//获得口红的锁
                System.out.println(this.girl + "获得口红");
                //1秒后想拥有镜子的锁
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(mirror) {//获得镜子的锁
                    System.out.println(this.girl + "获得镜子");
                }
            }


        } else {
            synchronized(mirror) {//获得镜子的锁
                //2秒后想拥有口红的锁
                System.out.println(this.girl + "获得镜子");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(lipstick) {//获得口红的锁
                    System.out.println(this.girl + "获得口红");
                }
            }




        } 
    }
}
