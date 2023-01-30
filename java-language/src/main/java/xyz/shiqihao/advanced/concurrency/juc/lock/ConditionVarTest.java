package xyz.shiqihao.advanced.concurrency.juc.lock;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 使用原子变量时 CPU 使用率接近100%
// 使用 condition variable 时 CPU 使用率接近0%
public class ConditionVarTest {
    private static final Lock lock = new ReentrantLock();
    private static final Condition cond = lock.newCondition();
    private static boolean isReady = false;
    private static AtomicBoolean atomicIsReady = new AtomicBoolean(false);

//    public static void main(String[] args) {
//        lock.lock();
//        try {
//            while (!isReady) {
//                cond.await();
//            }
//            Thread t1 = new Thread(new Task1());
//            t1.start();
//            t1.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } finally {
//            lock.unlock();
//        }
//    }

    static class Task1 implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(30 * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            lock.lock();
            try {
                isReady = true;
                cond.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new Task2());
        t.start();
        while (!atomicIsReady.get()) {
            Thread.yield();
        }
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static class Task2 implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(30 * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            atomicIsReady.set(true);
        }
    }
}