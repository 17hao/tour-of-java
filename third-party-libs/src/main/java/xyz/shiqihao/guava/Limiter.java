package xyz.shiqihao.guava;

import com.google.common.util.concurrent.RateLimiter;

/**
 * Guava中RateLimiter的基本用法
 */
public class Limiter {
    static RateLimiter limiter = RateLimiter.create(2);
     static class Task implements Runnable {
         @Override
         public void run() {
             System.out.println(System.currentTimeMillis());
         }
     }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            limiter.acquire();
            new Thread(new Task()).start();
        }
    }
}
