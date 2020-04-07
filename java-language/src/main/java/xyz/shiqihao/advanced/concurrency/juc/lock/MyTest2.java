package xyz.shiqihao.advanced.concurrency.juc.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock能响应中断防止死锁
 */
public class MyTest2 {
    static ReentrantLock apple = new ReentrantLock();
    static ReentrantLock pear = new ReentrantLock();

    static class Kid1 implements Runnable {
        @Override
        public void run() {
            try {
                // apple.lock();
                apple.lockInterruptibly();
                System.out.println("kid1 has an apple, waiting for a pear.");
                Thread.sleep(200);
                // pear.lock();
                pear.lockInterruptibly();
                System.out.println("kid1 has an apple and a pear!");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (apple.isHeldByCurrentThread()) {
                    apple.unlock();
                }
                if (pear.isHeldByCurrentThread()) {
                    pear.unlock();
                }
            }
        }
    }

    static class Kid2 implements Runnable {
        @Override
        public void run() {
            try {
                // pear.lock();
                pear.lockInterruptibly();
                System.out.println("kid2 has a pear, waiting for an apple.");
                Thread.sleep(200);
                // apple.lock();
                apple.lockInterruptibly();
                System.out.println("kid2 has an apple and a pear!");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (apple.isHeldByCurrentThread()) {
                    apple.unlock();
                }
                if (pear.isHeldByCurrentThread()) {
                    pear.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Kid1());
        Thread t2 = new Thread(new Kid2());
        t1.start();
        t2.start();
        t1.interrupt();
    }
}
