package xyz.shiqihao.advanced.concurrency.juc.sync;

import java.util.concurrent.Semaphore;

/**
 * Semaphore基本用法
 */
public class MyTest1<T> {
    private static final int MAX_AVAILABLE = 100;
    private Semaphore available = new Semaphore(MAX_AVAILABLE);

    public T getItem() throws InterruptedException {
        available.acquire();
        return getNextAvailableItem();
    }

    public void putItem(T t) {
        if (markAsUnused(t)) {
            available.release();
        }
    }

    protected Object[] items = new Object[MAX_AVAILABLE];
    protected boolean[] used = new boolean[MAX_AVAILABLE];

    protected synchronized T getNextAvailableItem() {
        for (int i = 0; i < MAX_AVAILABLE; i++) {
            if (!used[i]) {
                used[i] = true;
                return (T) items[i];
            }
        }
        return null;
    }

    protected synchronized boolean markAsUnused(T t) {
        for (int i = 0; i < MAX_AVAILABLE; i++) {
            if (t == items[i]) {
                if (used[i]) {
                    used[i] = false;
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
