package main.etc.concurrency.util.sync;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch demo
 */
public class CountDownDemo implements Runnable {
    private CountDownLatch counter = new CountDownLatch(10);

    @Override
    public void run() {
        try {
            int time = new Random().nextInt(1000);
            System.out.println("after " + time + " mills, check finished.");
            Thread.sleep(time);
            counter.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        CountDownDemo demo = new CountDownDemo();
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            service.submit(demo);
        }
        demo.counter.await();
        System.out.println("check finished");
        service.shutdown();
    }
}
