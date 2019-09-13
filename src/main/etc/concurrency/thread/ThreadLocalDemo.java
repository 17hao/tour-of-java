package main.etc.concurrency.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo {
    static class Task implements Runnable {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        @Override
        public void run() {
            threadLocal.set((int) (Math.random() * 100));
            threadLocal.set((int) (Math.random() * 100D));
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread" + Thread.currentThread().getId() + " generates: " + threadLocal.get());
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Task());
        Thread t2 = new Thread(new Task());
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.submit(t1);
        es.submit(t2);
        es.shutdown();
    }
}
