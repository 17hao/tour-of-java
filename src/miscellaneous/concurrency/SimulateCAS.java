package miscellaneous.concurrency;

public class SimulateCAS {
    private volatile int count;

    private synchronized int cas(int expectation, int newValue) {
        int curValue = count;
        if (expectation == curValue) {
            count = newValue;
        }
        return curValue;
    }

    void add10k() {
        int newValue;
        do {
            newValue = count + 1;                       // ①
        } while (count != cas(count, newValue));        // ②
    }

    public static void main(String[] args) throws InterruptedException {
        final SimulateCAS demo = new SimulateCAS();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                demo.add10k();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                demo.add10k();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(demo.count);
    }
}
