package xyz.shiqihao.advanced.concurrency.juc.collection;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList
 */
public class MyTest2 {
    private static final List<Integer> list = new CopyOnWriteArrayList<>();

    synchronized static void write() {
        int i = new Random().nextInt(10);
        System.out.println("add: " + i);
        list.add(i);
    }

    synchronized static void iterate() {
        System.out.print("list is: ");
        list.iterator().forEachRemaining(i -> System.out.print(i + " "));
        System.out.print("\n");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(MyTest2::write);
        Thread t2 = new Thread(MyTest2::write);
        Thread t3 = new Thread(MyTest2::write);
        t1.start();
        t2.start();
        t3.start();
        new Thread(MyTest2::iterate).start();
        new Thread(MyTest2::iterate).start();
    }
}
