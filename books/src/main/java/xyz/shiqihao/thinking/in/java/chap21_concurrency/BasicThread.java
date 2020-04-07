package xyz.shiqihao.thinking.in.java.chap21_concurrency;

/**
 * The most basic use of the Thread class
 */
public class BasicThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new LiftOff(10));
        thread.start();
        System.out.println("Waiting for LiftOff");
    }
}
