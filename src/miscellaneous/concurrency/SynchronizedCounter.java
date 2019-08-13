package miscellaneous.concurrency;

class SynchronizedCounter implements Counter {
    private int c = 0;

    @Override
    public synchronized void increment() {
        for (int i = 0; i < 10; i++) {
            c++;
            System.out.println("sync inc: " + c);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public synchronized void decrement() {
        for (int i = 0; i < 10; i++) {
            c--;
            System.out.println("sync dec: " + c);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public synchronized int value() {
        return c;
    }
}
