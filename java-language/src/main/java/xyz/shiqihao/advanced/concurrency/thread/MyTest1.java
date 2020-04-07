package xyz.shiqihao.advanced.concurrency.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程创建和启动的两种方式
 */
public class MyTest1 {
    public static void main(String[] args) {
        new Thread(new Hello()).start();
        new Hi().start();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Hello());
        executorService.execute(new Hi());
        executorService.shutdown();
    }

    static class Hello implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello, world");
        }
    }

    static class Hi extends Thread {
        @Override
        public void run() {
            System.out.println("Hi, world");
        }
    }
}
