package miscellaneous.concurrency;

public class Visibility {
    static class Thread1 implements Runnable {
        private Counter counter;

        Thread1(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.increment();
        }
    }

    static class Thread2 implements Runnable {
        private Counter counter;

        Thread2(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            System.out.println("thread2: " + counter.value());
        }
    }

    public static void main(String[] args) {
        Counter counter = new UnsafeCounter();
        new Thread(new Thread1(counter)).start();
        new Thread(new Thread2(counter)).start();
    }
}
