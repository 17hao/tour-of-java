package xyz.shiqihao.advanced.concurrency.pattern.thread_per_msg;

public class Helper {
    public void handle(int count, char c) {
        System.out.println(" \\_Helper handle(" + count + ", " + c + ") BEGIN");
        for (int i = 0; i < count; i++) {
            slowly();
            System.out.print(c);
        }
        System.out.println();
        System.out.println(" \\_Helper handle(" + count + ", " + c + ") END");
    }

    private void slowly() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
