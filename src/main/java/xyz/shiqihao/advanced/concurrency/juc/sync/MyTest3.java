package xyz.shiqihao.advanced.concurrency.juc.sync;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock and condition demo
 */
public class MyTest3 implements Runnable {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            condition.await();
            System.out.println("thread is going on");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTest3 t1 = new MyTest3();
        Thread thread = new Thread(t1);
        thread.start();
        Thread.sleep(1);
        lock.lock();
        condition.signal();
        lock.unlock();
    }
}
