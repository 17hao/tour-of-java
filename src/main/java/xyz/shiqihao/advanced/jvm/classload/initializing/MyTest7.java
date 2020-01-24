package xyz.shiqihao.advanced.jvm.classload.initializing;

/**
 * <clinit>方法自带锁, 多个线程同时初始化一个类可能会发生死锁.
 */
public class MyTest7 extends Thread {
    private char flag;

    private MyTest7(char flag) {
        this.flag = flag;
        this.setName("Thread " + flag);
    }

    @Override
    public void run() {
        try {
            Class.forName("xyz.shiqihao.advanced.jvm.classload.Static" + flag);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyTest7 a = new MyTest7('A');
        MyTest7 b = new MyTest7('B');
        System.out.println("start loading classes...");
        a.start();
        b.start();
    }
}

class StaticA {
    static {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Class.forName("xyz.shiqihao.advanced.jvm.classload.initializing.StaticB");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class StaticB {
    static {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Class.forName("xyz.shiqihao.advanced.jvm.classload.initializing.StaticA");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
