package xyz.shiqihao.java8.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateFilter {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (Integer i : filter(list, i -> i < 5)) {
            System.out.println(i);
        }
    }

    static List<Integer> filter(List<Integer> l, Predicate<Integer> p) {
        List<Integer> result = new ArrayList<>();
        for (Integer i : l) {
            if (p.test(i)) {
                result.add(i);
            }
        }
        return result;
    }
}
