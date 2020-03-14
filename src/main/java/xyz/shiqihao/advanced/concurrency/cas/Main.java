package xyz.shiqihao.advanced.concurrency.cas;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CasCounter counter = new CasCounter(new SimulatedCAS());

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                counter.increment();
            }
            System.out.println("after t1 executes, count is: " + counter.getValue());
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                counter.increment();
            }
            System.out.println("after t2 executes, count is: " + counter.getValue());
        });
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                counter.increment();
            }
            System.out.println("after t3 executes, count is: " + counter.getValue());
        });
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                counter.increment();
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
        System.out.println(counter.getValue());
    }
}
