package xyz.shiqihao.advanced.concurrency.util.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A BoundedBuffer that uses `Condition`.
 */
class BoundedBuffer {
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notNull = lock.newCondition();
    private final Object[] items = new Object[100];
    private int putptr, takeptr, count;

    void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length)
                notFull.await();
            items[putptr] = x;
            if (++putptr == items.length) putptr = 0;
            ++count;
            notNull.signalAll();
        } finally {
            lock.unlock();
        }
    }

    Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0)
                notNull.await();
            Object result = items[takeptr];
            if (--takeptr == items.length) takeptr = 0;
            --count;
            notFull.signalAll();
            return result;
        } finally {
            lock.unlock();
        }
    }
}

class Main {
    private static BoundedBuffer buffer = new BoundedBuffer();

    static private class put extends Thread {
        private int i;

        put(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                System.out.println("put: " + i);
                buffer.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static private class take extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("take: " + buffer.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            Thread t = new take();
            Thread p = new put(i);
            es.execute(t);
            es.execute(p);
        }
        es.shutdown();
    }
}
