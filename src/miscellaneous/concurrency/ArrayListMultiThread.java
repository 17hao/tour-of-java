package miscellaneous.concurrency;

import java.util.ArrayList;

public class ArrayListMultiThread {
    private static ArrayList<Integer> list = new ArrayList<>(10);

    private static class AddThread implements Runnable {
        @Override
        public void run() {
            int i = 0;
            while (i < 10000) {
                list.add(i);
                i++;
            }
        }
    }
    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(new AddThread());
        Thread t2 = new Thread(new AddThread());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(list.size());
    }
}
