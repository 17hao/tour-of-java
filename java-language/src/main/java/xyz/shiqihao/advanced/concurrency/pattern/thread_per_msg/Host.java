package xyz.shiqihao.advanced.concurrency.pattern.thread_per_msg;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Host {
    private Helper helper;
    private ScheduledExecutorService executor;

    public Host(Helper helper, ScheduledExecutorService executor) {
        this.helper = helper;
        this.executor = executor;
    }

    public void request(final int count, final char c) {
        executor.schedule(() -> helper.handle(count, c), 100, TimeUnit.MILLISECONDS);
        System.out.println(" \\_Host handle(" + count + ", " + c + ") END");
    }
}
