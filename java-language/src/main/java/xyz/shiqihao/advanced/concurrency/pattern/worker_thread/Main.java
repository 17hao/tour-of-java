package xyz.shiqihao.advanced.concurrency.pattern.worker_thread;

public class Main {
    public static void main(String[] args) {
        Channel channel = new Channel(5);
        channel.startWorkers();
        new ClientThread(channel, "alice").start();
        new ClientThread(channel, "bob").start();
        new ClientThread(channel, "chris").start();
    }
}
