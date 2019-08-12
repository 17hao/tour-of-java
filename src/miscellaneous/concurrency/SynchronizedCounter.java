package miscellaneous.concurrency;

class SynchronizedCounter implements Counter {
    private int c = 0;

    @Override
    public synchronized void increment() {
        for (int i = 0; i < 10000; i++) {
            c++;
        }
        System.out.println("after synchronized increment: " + c);
    }

    @Override
    public synchronized void decrement() {
        for (int i = 0; i < 10000; i++) {
            c--;
        }
        System.out.println("after synchronized decrement: " + c);
    }

    @Override
    public synchronized int value() {
        return c;
    }
}
