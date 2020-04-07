package xyz.shiqihao.advanced.concurrency.juc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SingleThreadPool其实是核心线程数和最大线程数都是1的FixedThreadPool
 */
public class MyTest2 {
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(() -> System.out.println(Thread.currentThread().getName()));
        es.shutdown();
    }
}
