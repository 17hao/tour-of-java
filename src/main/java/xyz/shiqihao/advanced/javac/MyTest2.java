package xyz.shiqihao.advanced.javac;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * java -Dmyconf=test
 */
public class MyTest2 {
    private final static AtomicInteger i = new AtomicInteger(0);
    private final static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) {
        MyTest2 t = new MyTest2();
        t.run0();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                System.out.println("JVM will quit after 10s.");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
    }

    private void run0() {
        System.out.println("JVM Arguments: " + System.getProperty("myconf"));

        ScheduledFuture<?> task = scheduler.scheduleAtFixedRate(new Task(), 0, 1, TimeUnit.SECONDS);
        scheduler.schedule(() -> task.cancel(false), 5, TimeUnit.SECONDS);

        synchronized (this) {
            while (true) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println(i.getAndAdd(1));
        }
    }
}
