package chapter21_concurrency.third_section;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    private Lock lock = new ReentrantLock();

    /**
     * Putting return statement outside lock will cause
     * thread unsafe if value is a global variable.
     *
     * @return even
     */
    @Override
    public int next() {
        lock.lock();
        try {
            ++currentEvenValue;
            Thread.yield();
            ++currentEvenValue;
        } finally {
            lock.unlock();
        }
        return currentEvenValue;
    }

    // @Override
    // public int next() {
    //     int value = 0;
    //     lock.lock();
    //     try {
    //         ++value;
    //         Thread.yield();
    //         ++value;
    //     } finally {
    //         lock.unlock();
    //     }
    //     return value;
    // }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());
    }
}
