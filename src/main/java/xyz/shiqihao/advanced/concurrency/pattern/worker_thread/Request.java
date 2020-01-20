package xyz.shiqihao.advanced.concurrency.pattern.worker_thread;

public class Request {
    private final String name;
    private final int num;

    public Request(String name, int num) {
        this.name = name;
        this.num = num;
    }

    @Override
    public String toString() {
        return "[ Request from " + name + " No." + num + " ]";
    }

    public void execute() {
        System.out.println(Thread.currentThread().getName() + " executes " + this);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
