package xyz.shiqihao.advanced.concurrency.pattern.worker_thread;

public class ClientThread extends Thread {
    private final Channel channel;

    public ClientThread(Channel channel, String name) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; true; i++) {
                Request r = new Request(getName(), i);
                channel.putRequest(r);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
