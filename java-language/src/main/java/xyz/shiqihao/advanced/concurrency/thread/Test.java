package xyz.shiqihao.advanced.concurrency.thread;

public class Test {
    public static void main(String[] args) throws InterruptedException {
    }
}

class T {
    private int i = 0;

    Runnable t1 = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                incr();
            }
            System.out.println(i);
        }

        synchronized private void incr() {
            i++;
        }
    };


    Runnable t2 = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                incr();
            }
            System.out.println(i);
        }

        synchronized private void incr() {
            i++;
        }
    };


}
