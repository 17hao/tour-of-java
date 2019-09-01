package miscellaneous.concurrency.util;

public class ThreadLocalDemo {
    private static class MyRunnable implements Runnable {
        private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        @Override
        public void run() {
            threadLocal.set((int) (Math.random() * 100D));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable sharedRunnable = new MyRunnable();

        Thread t1 = new Thread(sharedRunnable);
        Thread t2 = new Thread(sharedRunnable);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
