package xyz.shiqihao.advanced.concurrency.cas;

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
