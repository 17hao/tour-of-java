package miscellaneous.concurrency;

public class ThreadInterference {
    public static void main(String[] args) {
        Counter counter = new Counter();
        new Thread(new Thread1(counter)).start();
        new Thread(new Thread2(counter)).start();
    }
}

class Thread1 implements Runnable {
    private Counter counter;

    Thread1(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.increment();
        }
        System.out.println(counter.value());
    }
}

class Thread2 implements Runnable {
    private Counter counter;

    Thread2(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.decrement();
        }
        System.out.println(counter.value());
    }
}
