package xyz.shiqihao.advanced.concurrency.happensbefore;

/**
 * 调用join()方法使新线程中的动作happen-before调用的线程.
 */
public class MyTest1 {
    private static int x = 0;
    private static int y = 42;

    public static void main(String... args) throws InterruptedException {
        x = 10;
        Thread t = new Thread(() -> {
            y = x;
            System.out.println("[thread-t] y is: " + y);
        });
        t.start();
        t.join(); // enforce all actions in thread `t` happen-before main thread
        x = y + 1;
        System.out.println("[thread-main] x is: " + x);
    }
}
