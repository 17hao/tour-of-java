package xyz.shiqihao.java8.part1.FunctionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionMap {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("1234");
        l.add("2");
        l.add("asd");
        for (Integer i : map(l, String::length)) {
            System.out.println("length is: " + i);
        }
    }

    static <T, R> List<R> map(List<T> l, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T t : l) {
            result.add(f.apply(t));
        }
        return result;
    }
}
