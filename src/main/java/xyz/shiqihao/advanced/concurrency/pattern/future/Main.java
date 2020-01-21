package xyz.shiqihao.advanced.concurrency.pattern.future;

/**
 * Future模式在thread per message模式的基础上, 使主线程能获取到子线程执行的结果.
 * 很适合IO密集的任务, 将空闲的CPU出让给其他需要的线程, 当其他线程执行完毕, 再去获取在后台执行的线程的结果.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("main BEGIN!");
        Host host = new Host();
        Data d1 = host.request(3, 'a');
        Data d2 = host.request(6, 'b');
        Data d3 = host.request(9, 'c');

        System.out.println("main OTHER JOB START!");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main OTHER JOB END!");

        System.out.println("d1 = " + d1.getContent());
        System.out.println("d2 = " + d2.getContent());
        System.out.println("d3 = " + d3.getContent());
        System.out.println("main END!");
    }
}
