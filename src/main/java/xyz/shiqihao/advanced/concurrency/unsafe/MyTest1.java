package xyz.shiqihao.advanced.concurrency.unsafe;

/**
 * volatile关键字不能解决原子性的问题
 */
public class MyTest1 {
    static volatile int i = 0;

    //static AtomicInteger i = new AtomicInteger();
    static class PlusTask implements Runnable {
        @Override
        public void run() {
            //for (; i < 10000; i++) ;
            for (int k = 0; k < 10000; k++) {
                i++;
                //i.getAndIncrement();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threadGroup = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threadGroup[i] = new Thread(new PlusTask());
            threadGroup[i].start();
        }

        for (int i = 0; i < 10; i++) {
            threadGroup[i].join();
        }
        System.out.println("result: " + i);
    }
}
