package xyz.shiqihao.effectivejava.chap09;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Item58_PreferForEach {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        // Not the best way to iterate over a collection
        for (Iterator<Integer> i = l.iterator(); i.hasNext(); ) {
            Integer n = i.next();
            System.out.println(n);
        }

        // Not the best way to iterate over an array
        int[] array = {1, 2, 3, 4};
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        /**
         * The preferred way to iterate over collection and array
         * It gets rid of the clutter and the opportunity
         * for err by hiding the iterator or index variable
         */
        for (Integer i : l) {
            System.out.println(i);
        }

        for (Integer i : array) {
            System.out.println(i);
        }
    }
}
