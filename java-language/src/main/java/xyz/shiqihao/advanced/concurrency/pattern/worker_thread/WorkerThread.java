package xyz.shiqihao.advanced.concurrency.pattern.worker_thread;

public class WorkerThread extends Thread {
    private final Channel channel;

    public WorkerThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        channel.takeRequest().execute();
    }
}
