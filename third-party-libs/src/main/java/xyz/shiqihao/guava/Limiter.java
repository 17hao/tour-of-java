package xyz.shiqihao.guava;

import com.google.common.util.concurrent.RateLimiter;

import java.time.LocalDateTime;

/**
 * Guava中RateLimiter的基本用法
 */
public class Limiter {
    static RateLimiter limiter = RateLimiter.create(1); /* 1 permits per second */

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println(LocalDateTime.now());
            try {
                Thread.sleep(3000); /* sleep 3 seconds */
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            limiter.acquire();
            new Thread(new Task()).start();
        }
    }
}
