package miscellaneous.concurrency;

public class HappensBefore {
    private static int x = 0;
    private static int y = 42;

    public static void main(String... args) throws InterruptedException{
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
