package xyz.shiqihao.advanced.concurrency;

/**
 * 变量oldValue的值在①和②之间有可能被改变.
 */
public class SimulateCas {
    private volatile int count;

    private synchronized int cas(int expectation, int newValue) {
        int curValue = count;
        if (expectation == curValue) {
            count = newValue;
        }
        return curValue;
    }

    void increment() {
        int newValue, oldValue;
        do {
            oldValue = count;
            newValue = oldValue + 1;                       // ①
        } while (count != cas(oldValue, newValue));        // ②
    }

    public static void main(String[] args) throws InterruptedException {
        final SimulateCas demo = new SimulateCas();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                demo.increment();
            }
            System.out.println("after t1 executes, count is: " + demo.count);
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                demo.increment();
            }
            System.out.println("after t2 executes, count is: " + demo.count);
        });
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                demo.increment();
            }
            System.out.println("after t3 executes, count is: " + demo.count);
        });
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                demo.increment();
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        // System.out.println("after t1 executes, count is: " + demo.count);
        t2.join();
        // System.out.println("after t2 executes, count is: " + demo.count);
        t3.join();
        // System.out.println("after t3 executes, count is: " + demo.count);
        t4.join();
        System.out.println(demo.count);
    }
}
