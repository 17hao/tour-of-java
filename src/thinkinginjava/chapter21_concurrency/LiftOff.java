package thinkinginjava.chapter21_concurrency;

/**
 * Demonstration of the Runnable interface
 */
public class LiftOff implements Runnable {
    private int countDown = 5;
    private static int taskCount = 0;
    private final int id = taskCount++;

    LiftOff() {
    }

    LiftOff(int countDown) {
        this.countDown = countDown;
    }

    private String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff") + "),";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
    }
}
