package xyz.shiqihao.basic.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Demo1 {
    @Deprecated
    static void fromArrayToCollection(Object[] a, Collection<Object> c) {
        c.addAll(Arrays.asList(a));
    }

    static <T> void fromArrToCollection(T[] a, Collection<T> c) {
        c.addAll(Arrays.asList(a));
    }

    public static void main(String[] args) {
        List<String> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();
        List[] a = {l1, l2};
        Collection<List> c = new ArrayList<>();
        fromArrToCollection(a, c);
        // fromArrayToCollection(a, c); Compile time error!

        boolean isObject  = Collection.class.isAssignableFrom(Object.class);
        System.out.println(isObject); // false
    }
}

