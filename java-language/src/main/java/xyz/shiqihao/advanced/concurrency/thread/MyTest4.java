package xyz.shiqihao.advanced.concurrency.thread;

/**
 * ThreadGroup
 */
public class MyTest4 {
    static class Task implements Runnable {
        @Override
        public void run() {
            String name = Thread.currentThread().getThreadGroup().getName() + "-" +
                    Thread.currentThread().getName();
            System.out.println("I am: " + name);
        }
    }

    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("PrintGroup");
        Thread t1 = new Thread(group, new Task(), "thread1");
        Thread t2 = new Thread(group, new Task(), "thread2");
        t1.start();
        t2.start();
    }
}
