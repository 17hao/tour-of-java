package xyz.shiqihao.advanced.concurrency.juc.collection;

import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap
 */
public class MyTest1 {
    static ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

    static class Task implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                map.put(i, String.valueOf(i));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Task());
        Thread t2 = new Thread(new Task());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(map.size());
    }
}
