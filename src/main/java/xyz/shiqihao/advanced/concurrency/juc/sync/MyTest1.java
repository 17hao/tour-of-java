package xyz.shiqihao.advanced.concurrency.juc.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore基本用法
 */
public class MyTest1 {
    static Semaphore semaphore = new Semaphore(5);

    static class Task implements Runnable {
        @Override
        public void run() {
            try {
                semaphore.acquire();
                Thread.sleep(200);
                System.out.println(Thread.currentThread().getName() + " is done!");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            es.submit(new Task());
        }
        es.shutdown();
    }
}
