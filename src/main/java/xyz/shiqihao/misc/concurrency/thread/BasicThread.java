package xyz.shiqihao.misc.concurrency.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BasicThread {
    public static void main(String[] args) {
        new Thread(new Hello()).start();
        new Hi().start();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 2; i++) {
            executorService.execute(new Hello());
            executorService.execute(new Hi());
        }
        executorService.shutdown();
    }
}

class Hello implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello, world");
    }
}

class Hi extends Thread {
    @Override
    public void run() {
        System.out.println("Hi, world");
    }
}
