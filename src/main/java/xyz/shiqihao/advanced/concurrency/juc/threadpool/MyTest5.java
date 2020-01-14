package xyz.shiqihao.advanced.concurrency.juc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 用ThreadFactory自定义线程池中程创建的方式
 */
public class MyTest5 {
    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("do something...");
        }
    }

    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(5, 5, 0l,
                TimeUnit.MILLISECONDS,
                new SynchronousQueue<>(),
                r -> {
                    Thread t = new Thread(r);
                    t.setDaemon(false);
                    t.setName("Thread-RandomId-" + (int) (Math.random() * 1000));
                    System.out.println("create thread: " + t.getName());
                    return t;
                });

        for (int i = 0; i < 5; i++) {
            es.execute(new Task());
        }
        es.shutdown();
    }
}
