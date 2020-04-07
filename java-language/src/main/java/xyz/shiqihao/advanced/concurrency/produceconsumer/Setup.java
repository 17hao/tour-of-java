package xyz.shiqihao.advanced.concurrency.produceconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Setup {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(8);
        Producer<String> p1 = new Producer<>(queue);
        Producer<String> p2 = new Producer<>(queue);
        Producer<String> p3 = new Producer<>(queue);
    }
}
