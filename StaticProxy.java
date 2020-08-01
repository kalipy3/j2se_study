/*
 * StaticProxy.java
 * Copyright (C) 2020 kalipy <kalipy@debian>
 *
 * Distributed under terms of the MIT license.
 */

public class StaticProxy
{
    public static void main(String args[]) {
        new WeddingCompany(new You()).happyMarry();

        //new Thread(线程对象).start();
    }
}

interface Marry {
    void happyMarry();
}
//真实角色
class You implements Marry {
    public void happyMarry() {
        System.out.println("you marry..");
    }
}

//代理角色
class WeddingCompany implements Marry {
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }
    public void happyMarry() {
        ready();
        this.target.happyMarry();
        after();
    }

    private void ready() {
        System.out.println("ready..");
    }
    private void after() {
        System.out.println("after..");
    }
}
