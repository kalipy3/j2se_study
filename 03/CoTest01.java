/*协作模型：生产者消费者实现方式一：管程法（缓冲区通道
 *
 * */
public class CoTest01 {
    public static void main(String args[]) {
        SynContainer container = new SynContainer();
        new Productor(container).start();
        new Consumer(container).start();
    }
}

//生产者
class Productor extends Thread {
    SynContainer container;
    public Productor(SynContainer container) {
        this.container = container;
    }
    public void run() {
        //生产
        for (int i = 0; i < 100; i++) {
            System.out.println("生产-->"+i+"个馒头");
            container.push(new Steamedbun(i));
        }
    }
}
//消费者
class Consumer extends Thread {
    SynContainer container;
    public Consumer(SynContainer container) {
        this.container = container;
    }
    public void run() {
        //消费
        for (int i = 0; i < 1000; i++) {
            System.out.println("消费-->"+container.pop().id+"个馒头");
        }

    }
}
//缓冲区
class SynContainer {
    Steamedbun[] buns = new Steamedbun[10];//存储容器
    int count = 0;//计数器
    //存储 生产
    public void push(Steamedbun bun) {
        buns[count] = bun;
        count++;
    }
    //获取 消费
    public Steamedbun pop() {
        count--;
        Steamedbun bun = buns[count];
        return bun;
    }
}
//馒头
class Steamedbun {
    int id;

    public Steamedbun(int id) {
        this.id = id;
    }
}
