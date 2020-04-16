package xyz.shiqihao.advanced.concurrency.juc.sync;

import java.util.UUID;

/**
 * ThreadLocal适用于某个非线程安全的变量要在多个线程间共享,但是不想进行同步操作.
 * ThreadLocal存放了当前线程的局部变量, 它的关键实现是内部的ThreadLocalMap类,
 * 这是一个自定义的HashMap, key是ThreadLocal对象的引用, value是局部变量值.
 */
public class MyTest4 {
    private static final ThreadLocal<String> tl = ThreadLocal.withInitial(() -> UUID.randomUUID().toString());

    static class Task implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tl.set(UUID.randomUUID().toString());
            System.out.println(Thread.currentThread().getName() +
                    " generates: " + tl.get());
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
