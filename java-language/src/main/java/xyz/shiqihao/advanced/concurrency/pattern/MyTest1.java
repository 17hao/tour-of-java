package xyz.shiqihao.advanced.concurrency.pattern;

import java.util.concurrent.*;

/**
 * Future基本用法
 */
public class MyTest1 {
    private ExecutorService es = new ThreadPoolExecutor(5, 5,
            0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10));

    Future<Integer> computeInFuture(int i, int j) {
        Future<Integer> result = es.submit(() -> i + j);
        es.shutdown();
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        MyTest1 demo = new MyTest1();
        Future<Integer> future = demo.computeInFuture(1, 2);
        CountDownLatch signal = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println(signal.getCount() + " s remaining");
            signal.countDown();
        }
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}