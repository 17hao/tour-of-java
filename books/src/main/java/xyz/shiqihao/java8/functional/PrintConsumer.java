package xyz.shiqihao.java8.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PrintConsumer {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        forEach(list, System.out::println);
    }

    static void forEach(List<Integer> l, Consumer<Integer> c) {
        for (Integer i : l) {
            c.accept(i);
        }
    }
}
