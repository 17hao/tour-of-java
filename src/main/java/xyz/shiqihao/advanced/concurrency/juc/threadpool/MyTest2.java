package xyz.shiqihao.advanced.concurrency.juc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SingleThreadPool
 */
public class MyTest2 {
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(() -> System.out.println(Thread.currentThread().getName()));
        es.shutdown();
    }
}
