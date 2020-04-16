package xyz.shiqihao.advanced.concurrency.unsafe;

import java.util.HashMap;
import java.util.Map;

public class MultiThreadHashMap {
    private final Map<Integer, String> map = new HashMap<>(1);

    void doSomething() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            map.put(1, "v");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            map.put(2, "v");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t5 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(map.get(1));
        });
        Thread t6 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(map.get(1));
        });
        t1.start();
        t2.start();
        t5.start();
        t6.start();
        t1.join();
        t2.join();
        t5.join();
        t6.join();
    }

    public static void main(String[] args) throws InterruptedException {
        MultiThreadHashMap m = new MultiThreadHashMap();
        m.doSomething();
    }
}
