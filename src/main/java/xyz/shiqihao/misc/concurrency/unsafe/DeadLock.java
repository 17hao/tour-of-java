package xyz.shiqihao.misc.concurrency.unsafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLock {
    private static final Object apple = new Object();
    private static final Object pear = new Object();

    private static class Kid1 implements Runnable {
        @Override
        public void run() {
            synchronized (apple) {
                System.out.println("kid 1 has an apple");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println(e.toString());
                }
                System.out.println("kid 1 is waiting for pear");
                synchronized (pear) {
                    System.out.println("kid 1 has apple and pear");
                }
            }
        }
    }

    private static class Kid2 implements Runnable {
        @Override
        public void run() {
            synchronized (pear) {
                System.out.println("kid 2 has a pear");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println(e.toString());
                }
                System.out.println("kid 2 is waiting for apple");
                synchronized (apple) {
                    System.out.println("kid 2 has apple and pear");
                }
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Kid1());
        executorService.execute(new Kid2());
        executorService.shutdown();
    }
}
