package xyz.shiqihao.thinking.in.java.chap21_concurrency.third_section;

public abstract class IntGenerator {
    private volatile boolean canceled = false;

    public abstract int next();

    void cancel() {
        canceled = true;
    }

    boolean isCanceled() {
        return canceled;
    }
}
