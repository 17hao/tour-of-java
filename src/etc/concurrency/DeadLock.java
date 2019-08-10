package etc.concurrency;

public class DeadLock {
    private static final Object apple = new Object();
    private static final Object pear = new Object();

    private static class Kid1 extends Thread {
        @Override
        public void run() {
            synchronized (apple) {
                System.out.println("kid 1 has an apple");
                try {
                    Kid1.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println(e.toString());
                }
                System.out.println("kid 1 is waiting for pear");
                synchronized (pear) {
                    System.out.println("kid 1 has apple and pear");
                }
            }
        }
    }

    private static class Kid2 extends Thread {
        @Override
        public void run() {
            synchronized (pear) {
                System.out.println("kid 2 has a pear");
                try {
                    Kid2.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println(e.toString());
                }
                System.out.println("kid 2 is waiting for apple");
                synchronized (apple) {
                    System.out.println("kid 2 has apple and pear");
                }
            }
        }
    }

    public static void main(String[] args) {
        Kid1 k1 = new Kid1();
        Kid2 k2 = new Kid2();
        k1.start();
        k2.start();
    }
}
