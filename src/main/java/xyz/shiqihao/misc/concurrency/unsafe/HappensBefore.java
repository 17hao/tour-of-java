package xyz.shiqihao.misc.concurrency.unsafe;

public class HappensBefore {
    private static int x = 0;
    private static int y = 42;

    public static void main(String... args) throws InterruptedException{
        x = 0;
        Thread t = new Thread(() -> {
            y = x;
            System.out.println("t's y is: " + y);
        });
        t.start();
        t.join(); // enforce all actions in t happen-before main thread
        x = y + 1;
        System.out.println("x is: " + x);
    }
}

class Example {
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
