package xyz.shiqihao.misc.concurrency.util.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo2 {
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(() -> System.out.println(Thread.currentThread().getName()));
        es.shutdown();
    }
}
