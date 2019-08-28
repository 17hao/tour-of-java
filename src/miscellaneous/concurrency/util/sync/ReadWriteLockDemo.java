package miscellaneous.concurrency.util.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWriteLock demo
 */
public class ReadWriteLockDemo {
    private Lock lock = new ReentrantLock();
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
    private ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
    private int value;

    private int read(Lock lock) {
        try {
            lock.lock();
            Thread.sleep(1000);
            return value;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return value;
        } finally {
            lock.unlock();
        }
    }

    private void write(Lock lock) {
        try {
            lock.lock();
            Thread.sleep(1000);
            value = 1;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockDemo demo = new ReadWriteLockDemo();
        Runnable readHandler = () -> {
            //demo.read(demo.lock);
            demo.read(demo.readLock);
        };

        Runnable writeHandler = () -> {
            //demo.write(demo.lock);
            demo.write(demo.writeLock);
        };

        for (int i = 0; i < 18; i++) {
            new Thread(readHandler).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(writeHandler).start();
        }
    }
}
