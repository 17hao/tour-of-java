package xyz.shiqihao.advanced.concurrency.juc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CachedThreadPool, 核心线程数0, 最大线程数Integer.MAX_VALUE
 */
public class MyTest3 {
    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("[Thread id]: " + Thread.currentThread().getId());
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            es.execute(new Task());
        }
    }
}
