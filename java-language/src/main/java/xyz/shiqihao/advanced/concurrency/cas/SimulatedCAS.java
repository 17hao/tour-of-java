package xyz.shiqihao.advanced.concurrency.cas;

/**
 * 变量oldValue的值在①和②之间有可能被改变.
 */
public class SimulatedCAS {
    private int value;

    public int getValue() {
        return value;
    }

    public synchronized int compareAndSwap(int expectValue, int newValue) {
        int oldValue = value;
        if (oldValue == expectValue) {
            value = newValue;
        }
        return oldValue;
    }

    public synchronized boolean compareAndSet(int expectValue, int newValue) {
        return (expectValue == compareAndSwap(expectValue, newValue));
    }
}
