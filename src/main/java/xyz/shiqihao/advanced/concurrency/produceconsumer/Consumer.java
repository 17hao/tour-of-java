package xyz.shiqihao.advanced.concurrency.produceconsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer<T> implements Runnable {
    private BlockingQueue<T> queue;

    public Consumer(BlockingQueue<T> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            consume(queue.take());
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    void consume(T t) {
        System.out.println(t);
    }
}
