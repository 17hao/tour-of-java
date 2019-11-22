package xyz.shiqihao.advanced.concurrency.unsafe;

import java.util.concurrent.locks.ReentrantLock;

interface Counter {
    void increment();

    void decrement();

    int value();
}