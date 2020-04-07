package xyz.shiqihao.advanced.concurrency.juc.threadpool;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledExecutorService
 */
public class MyTest7 {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void beepForAnHour() {
        final Runnable beeper = () -> System.out.println(LocalDateTime.now() + " beep");

        final ScheduledFuture<?> beepHandle = scheduler.scheduleAtFixedRate(beeper, 0, 2, TimeUnit.SECONDS);

        scheduler.schedule(() -> beepHandle.cancel(true), 60 * 60, TimeUnit.MINUTES);
    }

    public static void main(String[] args) {
        MyTest7 test = new MyTest7();
        test.beepForAnHour();
    }
}
