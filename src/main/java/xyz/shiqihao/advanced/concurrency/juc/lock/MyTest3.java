package xyz.shiqihao.advanced.concurrency.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition的基本用法
 */
public class MyTest3 {
    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("thread started...");
            try {
                lock.lock();
                condition.await();
                System.out.println("thread is going on...");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Task());
        t1.start();
        System.out.println("thread interrupted...");
        Thread.sleep(5000);
        lock.lock();
        condition.signal();
        lock.unlock();
    }
}
