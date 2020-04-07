package xyz.shiqihao.advanced.concurrency.unsafe;

interface Counter {
    void increment();

    void decrement();

    int value();
}