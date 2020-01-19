package xyz.shiqihao.advanced.concurrency.pattern.thread_per_msg;

public class Host {
    private Helper helper;

    public Host(Helper helper) {
        this.helper = helper;
    }

    public void request(final int count, final char c) {
        new Thread(() -> helper.handle(count, c)).start();
        System.out.println(" \\_Host handle(" + count + ", " + c + ") END");
    }
}
