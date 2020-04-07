package xyz.shiqihao.advanced.concurrency.happensbefore;

public class MyTest2 {
    int i = 0;
    volatile boolean f = false;

    void writer() {
        i++;
        f = true;
    }

    void reader() {
        if (f) {
            // 根据happens-before规则,此处i的值?
        }
    }
}
