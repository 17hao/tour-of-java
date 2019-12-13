package xyz.shiqihao.advanced.jvm.classload;

/**
 * <clinit>方法自带锁, 多个线程同时初始化一个类可能会发生死锁.
 */
public class ClassInitDeadLock extends Thread {
    private char flag;

    private ClassInitDeadLock(char flag) {
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
        ClassInitDeadLock a = new ClassInitDeadLock('A');
        ClassInitDeadLock b = new ClassInitDeadLock('B');
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
            Class.forName("xyz.shiqihao.advanced.jvm.classload.StaticB");
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
            Class.forName("xyz.shiqihao.advanced.jvm.classload.StaticA");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
