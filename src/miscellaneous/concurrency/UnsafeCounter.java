package miscellaneous.concurrency;

class UnsafeCounter implements Counter {
    private int c = 0;

    @Override
    public void increment() {
        for (int i = 0; i < 10000; i++) {
            c++;
        }
        System.out.println("after unsafe increment: " + c);
    }

    @Override
    public void decrement() {
        for (int i = 0; i < 10000; i++) {
            c--;
        }
        System.out.println("after unsafe decrement: " + c);
    }

    @Override
    public int value() {
        return c;
    }
}
