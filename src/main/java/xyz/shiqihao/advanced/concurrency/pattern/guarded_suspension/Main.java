package xyz.shiqihao.advanced.concurrency.pattern.guarded_suspension;

import java.util.concurrent.ThreadFactory;

/**
 * 线程与进程的一个重要的区别在于进程有自己独立的内存空间, 而线程间共享了部分内存.
 * 所以线程间的通信可以通过共享内存进行.
 * 对于Java来说, 线程间的共享内存就是互相操作创建在堆上的对象或者是常量池中的常量.
 * guarded suspension的含义是: 多个线程对共享内存做操作时, 先检查操作的合法性, 合法时进行操作, 不合法时线程挂起.
 */
public class Main {
    public static void main(String[] args) {
        // ThreadFactory factory = Thread::new;
        // RequestQueue queue = new RequestQueue();
        // factory.newThread(new ClientThread(queue, "client")).start();
        // factory.newThread(new ServerThread(queue, "server")).start();

        RequestQueue queue = new RequestQueue();
        new ClientThread(queue, "client").start();
        new ServerThread(queue, "server").start();
    }
}
