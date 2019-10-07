package xyz.shiqihao.thinkinginjava.chap21_concurrency.third_section;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable {
    private int i = 0;

    /**
     * The value will be read in a unstable status without 'synchronized' keyword!
     *
     * @return
     */
    synchronized int getValue() {
        return i;
    }

    synchronized void evenIncrement() {
        i++;
        i++;
    }

    @Override
    public void run() {
        while (true)
            evenIncrement();
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        exec.execute(at);
        while (true) {
            int val = at.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
