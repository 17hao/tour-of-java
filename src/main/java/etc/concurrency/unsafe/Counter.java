package etc.concurrency.unsafe;

import java.util.concurrent.locks.ReentrantLock;

interface Counter {
    void increment();

    void decrement();

    int value();
}

class SynchronizedCounter implements Counter {
    private int c = 0;

    @Override
    public synchronized void increment() {
        for (int i = 0; i < 10; i++) {
            c++;
            System.out.println("sync inc: " + c);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public synchronized void decrement() {
        for (int i = 0; i < 10; i++) {
            c--;
            System.out.println("sync dec: " + c);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public synchronized int value() {
        return c;
    }
}

class LockCounter implements Counter {
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