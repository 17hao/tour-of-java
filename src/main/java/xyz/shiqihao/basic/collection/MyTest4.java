package xyz.shiqihao.basic.collection;

import java.util.ArrayList;
import java.util.List;

public class MyTest4 {
    public static void main(String[] args) {
        List<List<Integer>> ll = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(1);
        ll.add(new ArrayList<>(l));
        ll.add(l);
        System.out.println(ll);
    }
}
