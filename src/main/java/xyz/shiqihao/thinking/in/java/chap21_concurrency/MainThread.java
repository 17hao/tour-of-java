package xyz.shiqihao.thinking.in.java.chap21_concurrency;

public class MainThread {
    public static void main(String[] args) {
        LiftOff launch = new LiftOff(10);
        launch.run();
    }
}
