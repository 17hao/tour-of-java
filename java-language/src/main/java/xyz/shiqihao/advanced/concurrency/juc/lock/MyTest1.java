package xyz.shiqihao.advanced.concurrency.juc.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock基本用法
 */
public class MyTest1 {
    static int i = 0;
    static ReentrantLock lock = new ReentrantLock();

    static class Task implements Runnable {

        @Override
        public void run() {
            try {
                lock.lock();
                lock.lock();
                for (int j = 0; j < 100; j++) {
                    i++;
                }
            } finally {
                lock.unlock();
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Task());
        Thread t2 = new Thread(new Task());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("result: " + i);
    }
}
