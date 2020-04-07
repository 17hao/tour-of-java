package xyz.shiqihao.advanced.concurrency.pattern.guarded_suspension;

public class ClientThread extends Thread {
    private final RequestQueue queue;

    public ClientThread(RequestQueue queue, String name) {
        super(name);
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Request r = new Request("No." + i);
            System.out.println(Thread.currentThread().getName() + " requests " + r);
            queue.putRequest(r);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
