package miscellaneous.concurrency;

public class ThreadInterference {
    public static void main(String[] args) {
        Counter counter = new UnsafeCounter();
        Counter counter2 = new SynchronizedCounter();
        new Thread(new Thread1(counter)).start();
        new Thread(new Thread2(counter)).start();
        new Thread(new Thread1(counter2)).start();
        new Thread(new Thread2(counter2)).start();
    }
}

class Thread1 implements Runnable {
    private Counter counter;

    Thread1(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.increment();
    }
}

class Thread2 implements Runnable {
    private Counter counter;

    Thread2(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.decrement();
    }
}
