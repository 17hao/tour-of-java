package xyz.shiqihao.advanced.concurrency.pattern.worker_thread;

public class Channel {
    private final Request[] requestQueue;
    private int head;
    private int tail;
    private int count;

    private final WorkerThread[] threadPool;

    public Channel(int threads) {
        this.requestQueue = new Request[100];
        this.head = 0;
        this.tail = 0;
        this.count = 0;

        threadPool = new WorkerThread[threads];
        for (int i = 0; i < threads; i++) {
            threadPool[i] = new WorkerThread("Worker-" + i, this);
        }
    }

    public void startWorkers() {
        for (WorkerThread worker : threadPool) {
            worker.start();
        }
    }

    public synchronized void putRequest(Request r) {
        while (count >= requestQueue.length) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        requestQueue[tail] = r;
        tail = (tail + 1) % requestQueue.length;
        count++;
        notifyAll();
    }

    public synchronized Request takeRequest() {
        while (count <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Request request = requestQueue[head];
        head = (head + 1) % requestQueue.length;
        count--;
        notifyAll();
        return request;
    }
}
