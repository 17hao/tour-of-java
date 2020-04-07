package xyz.shiqihao.advanced.concurrency.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition和Lock结合使用
 * ArrayBlockingQueue
 */
class BoundedBuffer {
    private Object[] items = new Object[100];

    private Lock lock = new ReentrantLock();

    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    int putPtr, takePtr, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await();
            }
            items[putPtr++] = x;
            count++;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            Object x = items[takePtr++];
            count--;
            notEmpty.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
}
