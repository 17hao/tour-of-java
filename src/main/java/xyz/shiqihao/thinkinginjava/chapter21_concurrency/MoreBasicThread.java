package xyz.shiqihao.thinkinginjava.chapter21_concurrency;

/**
 * Add more threads
 */
public class MoreBasicThread {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");
    }
}
