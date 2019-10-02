package xyz.shiqihao.misc.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class RotatePrint {
    private AtomicInteger count = new AtomicInteger();

    private Thread a = new Thread(() -> {
        System.out.println(Thread.currentThread().getId() + " A print: " + count);
        count.getAndIncrement();
    });

    private Thread b = new Thread(() -> {
        System.out.println(Thread.currentThread().getId() + " B print: " + count);
        count.getAndIncrement();
    });

    private Thread c = new Thread(() -> {
        System.out.println(Thread.currentThread().getId() + " C print: " + count);
        count.getAndIncrement();
    });

    public static void main(String[] args) throws InterruptedException {
        RotatePrint print = new RotatePrint();
        ExecutorService es = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            es.submit(print.a);
            es.awaitTermination(1000, TimeUnit.MILLISECONDS);
            es.submit(print.b);
            es.awaitTermination(1000, TimeUnit.MILLISECONDS);
            es.submit(print.c);
            es.awaitTermination(1000, TimeUnit.MILLISECONDS);
        }
        es.shutdown();
    }
}