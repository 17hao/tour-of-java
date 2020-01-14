package xyz.shiqihao.advanced.concurrency.juc.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledThreadPoolExecutor可以周期性地执行一项任务.
 * (1) 调用schedule()方法, 如果执行的任务时间大于调度周期时间, 那么下一次调度会推迟到上一个任务执行完.
 */
public class MyTest4 {
    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + " [" + Thread.currentThread().getId() +
                    "] is doing something...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ScheduledExecutorService es = Executors.newScheduledThreadPool(2);
        for (int i = 0; i < 10; i++) {
            es.schedule(new Task(), 1, TimeUnit.SECONDS);
        }
        es.shutdown();
    }
}
