package main.miscellaneous.concurrency.unsafe;

public class Visibility {
    private int count;

    private void add() {
        int i = 0;
        while (i < 100000) {
            count++;
            i++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final Visibility v = new Visibility();
        Thread th1 = new Thread(v::add);
        Thread th2 = new Thread(v::add);

        th1.start();
        th2.start();
        th1.join();
        th2.join();

        System.out.println(v.count);
    }
}
