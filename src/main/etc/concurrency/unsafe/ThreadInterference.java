package main.etc.concurrency.unsafe;

public class ThreadInterference {
    static class Inc implements Runnable {
        private Counter counter;

        Inc(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.increment();
        }
    }

    static class Dec implements Runnable {
        private Counter counter;

        Dec(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.decrement();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter unsafeCounter = new UnsafeCounter();
        Thread t1 = new Thread(new Inc(unsafeCounter));
        Thread t2 = new Thread(new Dec(unsafeCounter));
        t1.start();
        t2.start();
         t1.join();
         t2.join();

        // Counter synchronizedCounter = new SynchronizedCounter();
        // Thread t1 = new Thread(new Inc(synchronizedCounter));
        // Thread t2 = new Thread(new Dec(synchronizedCounter));
        // t1.start();
        // t2.start();
        // t1.join();
        // t2.join();

        // Counter lockCounter = new LockCounter();
        // Thread t1 = new Thread(new Inc(lockCounter));
        // Thread t2 = new Thread(new Dec(lockCounter));
        // t1.start();
        // t2.start();
        // t1.join();
        // t2.join();
    }
}