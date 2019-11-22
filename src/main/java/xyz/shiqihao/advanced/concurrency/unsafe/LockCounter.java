package xyz.shiqihao.advanced.concurrency.unsafe;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Thread safe counter that uses ReentrantLock.
 */
public class LockCounter implements Counter {
    private int c = 0;

    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void increment() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                c++;
                System.out.println("lock inc: " + c);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
        }

    }

    @Override
    public void decrement() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                c--;
                System.out.println("lock dec: " + c);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int value() {
        return c;
    }
}