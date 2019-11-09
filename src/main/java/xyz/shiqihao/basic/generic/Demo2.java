package xyz.shiqihao.basic.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Demo2 {
    public static void main(String[] args) {
        Collection<String> ls = new ArrayList<>();

        Collection<Object> lo = Collections.singleton(ls);

        ls.add("a");
        for (Object o : lo) {
            System.out.println(o);
        }


        System.out.println("=====");
        ls.add("b");
        for (Object o : lo) {
            System.out.println(o);
        }

    }
}
