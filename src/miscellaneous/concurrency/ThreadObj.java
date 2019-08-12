package miscellaneous.concurrency;

public class ThreadObj {
    public static void main(String[] args) {
        new Thread(new Hello()).start();
        new Hi().start();
    }
}

class Hello implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello, world");
    }
}

class Hi extends Thread {
    @Override
    public void run() {
        System.out.println("Hi, world");
    }
}
