package xyz.shiqihao.advanced.concurrency.thread;

/**
 * Thread类中join()方法演示
 */
public class MyTest3 {
    static volatile int i = 0;
    static class T1 implements Runnable {
        @Override
        public void run() {
            for (; i < 100000; i++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new T1());
        t1.start();
        t1.join(); // join()方法使其他线程等待t1线程先执行完.
        System.out.println(i);
    }
}
