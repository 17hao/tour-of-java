package xyz.shiqihao.advanced.concurrency.pattern.guarded_suspension;

public class ServerThread extends Thread {
    private final RequestQueue queue;

    public ServerThread(RequestQueue queue, String name) {
        super(name);
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Request r = queue.getRequest();
            System.out.println(Thread.currentThread().getName() + " handles " + r);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
