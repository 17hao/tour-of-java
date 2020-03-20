package xyz.shiqihao.advanced.concurrency.juc.sync;

import java.util.ArrayList;
import java.util.List;

/**
 * ThreadLocal基本用法.
 * ThreadLocal存放了当前线程的局部变量, 它的关键实现是内部的ThreadLocalMap类,
 * 这是一个自定义的HashMap, key是ThreadLocal对象的引用, value是局部变量值.
 */
public class MyTest4 {
    private static ThreadLocal<List<Integer>> tl = new ThreadLocal<>();

    static class Task implements Runnable {
        @Override
        public void run() {
            if (tl.get() == null) {
                tl.set(new ArrayList<>());
            }
            tl.get().add((int) (Math.random() * 100));
            tl.get().add((int) (Math.random() * 100));
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +
                    " generates: " + tl.get().get(0) + " and " + tl.get().get(1));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Task());
        Thread t2 = new Thread(new Task());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
