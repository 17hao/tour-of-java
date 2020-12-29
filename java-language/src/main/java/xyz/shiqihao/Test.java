package xyz.shiqihao;

public class Test {
    public synchronized void A() {
        System.out.println("a");
    }

    public synchronized static void B() {
        System.out.println("b");
    }
}