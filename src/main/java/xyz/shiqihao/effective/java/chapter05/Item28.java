package xyz.shiqihao.effective.java.chapter05;

import java.util.ArrayList;
import java.util.List;

/**
 * 优先考虑使用list而不是数组.
 */
public class Item28 {
    public static void main(String[] args) {
        // Array is covariant. List is invariant.
        // Fails at runtime!
        Object[] objectArray = new Long[1];
        objectArray[0] = "str"; // Throws ArrayStoreException

        List<Long> l = new ArrayList<>();
        //l.add("str") // Won't compile!
    }

    //List<String>[] stringList = new List<String>[1]; // Generic array is illegal.
    List<Integer> list = new ArrayList<>(1);
}
