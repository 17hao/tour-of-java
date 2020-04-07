package xyz.shiqihao.advanced.concurrency.thread;

/**
 * Object类中wait()和notify()方法演示
 */
public class MyTest2 {
    final static Object lock = new Object();

    static class T1 implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(System.currentTimeMillis() + ": T1 start!");
                try {
                    System.out.println(System.currentTimeMillis() + ": T1 is waiting for lock.");
                    lock.wait(); // 直到再次获取到lock对象的monitor以后才能执行后续操作.
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ": T1 exit!");
            }
        }
    }

    static class T2 implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(System.currentTimeMillis() + ": T2 start!");
                try {
                    lock.notify();
                    System.out.println(System.currentTimeMillis() + ": T2 exit!");
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new T1());
        Thread t2 = new Thread(new T2());
        t1.start();
        t2.start();
    }
}
