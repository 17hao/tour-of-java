package xyz.shiqihao.advanced.concurrency.produceconsumer;

import java.util.concurrent.BlockingQueue;

public class Producer<T> implements Runnable {
    private BlockingQueue<T> queue;

    private T t;

    public void setT(T t) {
        this.t = t;
    }

    public Producer(BlockingQueue<T> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            queue.put(produce());
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    T produce() {
        return t;
    }
}
