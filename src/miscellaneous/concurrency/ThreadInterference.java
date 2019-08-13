package miscellaneous.concurrency;

public class ThreadInterference {
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
            counter.decrement();
        }
    }

    public static void main(String[] args) {
        // Counter counter = new UnsafeCounter();
        // new Thread(new Thread1(counter)).start();
        // new Thread(new Thread2(counter)).start();
        Counter counter2 = new SynchronizedCounter();
        new Thread(new Thread1(counter2)).start();
        new Thread(new Thread2(counter2)).start();
    }
}