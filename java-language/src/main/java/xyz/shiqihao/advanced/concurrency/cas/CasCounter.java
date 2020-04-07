package xyz.shiqihao.advanced.concurrency.cas;

/**
 * public int increment() {
 *      int newV;
 *      do {
 *          newV = getValue() + 1;                                // ①
 *      } while (getValue() != cas.compareAndSwap(getValue(), newV));   // ②
 *      return newV;
 * }
 *
 * 多个线程可能在①和②处有可见性问题. getValue()获取的值在①和②之间可能被改变了, 但是当前线程还不知道.
 */
public class CasCounter {
    private SimulatedCAS cas;

    public CasCounter(SimulatedCAS cas) {
        this.cas = cas;
    }

    public int getValue() {
        return cas.getValue();
    }

    public int increment() {
        int v;
        do {
            v = getValue();
        } while (v != cas.compareAndSwap(v, v + 1));
        return v + 1;
    }
}
