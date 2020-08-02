/*
 *同步块
 * */

public class SynBlockTest01 {
    public static void main(String args[]) {
        Account account = new Account(1000, "结婚礼金");
        SafeDrawing you = new SafeDrawing(account, 80, "可悲的你");
        SafeDrawing wife = new SafeDrawing(account, 90, "happy的她");
        you.start();
        wife.start();
    }
}
//账户
class Account {
    int money;
    String name;
    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//模拟取钱
class SafeDrawing extends Thread {
    Account account;//取钱的账户
    int drawingMoney;//取走的钱数
    int drawingTotal;//取走的总数

    public SafeDrawing(Account account, int drawingMoney, String name) {
        super(name);//Thread类传入的name
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    public void run() {
        test();
    }

    //锁account
    public void test() {
        //提高性能
        if (account.money <= 0) {
            return;
        }

        synchronized(account) {
            if (account.money-drawingMoney < 0) {
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            account.money -= drawingMoney;
            drawingTotal += drawingMoney;
            System.out.println(this.getName()+"-->账户余额为："+account.money);
            System.out.println(this.getName()+"-->口袋的钱为："+drawingTotal);


        }   
    }
}
