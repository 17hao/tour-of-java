package xyz.shiqihao.effectivejava.chap05_Generics;

import java.util.ArrayList;
import java.util.List;

public class Item28_PreferListToArray {
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
