package xyz.shiqihao.advanced.concurrency.cas;

/**
 * public int increment() {
 *      int oldV, newV;
 *      do {
 *          oldV = getValue();
 *          newV = oldV + 1;                                // ①
 *      } while (getValue() != cas.compareAndSwap(oldV, newV));   // ②
 *      return newV;
 * }
 *
 * 多个线程可能在①和②处有可见性问题.
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
