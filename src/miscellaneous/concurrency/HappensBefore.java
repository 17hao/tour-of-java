package miscellaneous.concurrency;

public class HappensBefore {
    private static int x = 0;
    private static int y = 42;

    public static void main(String... args) {
        x = 1;
        Thread t = new Thread(() -> {
            y = x;
            System.out.println(y); // output 43 or 1
        });
        t.start();
        x = y + 1;
    }
}
