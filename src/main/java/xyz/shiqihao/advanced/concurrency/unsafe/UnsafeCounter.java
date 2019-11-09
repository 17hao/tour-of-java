package xyz.shiqihao.advanced.concurrency.unsafe;

class UnsafeCounter implements Counter {
    private int c = 0;

    @Override
    public void increment() {
        for (int i = 0; i < 10; i++) {
            c++;
            System.out.println("inc: " + c);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void decrement() {
        for (int i = 0; i < 10; i++) {
            c--;
            System.out.println("dec: " + c);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public int value() {
        return c;
    }
}
