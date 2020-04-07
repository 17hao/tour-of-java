package xyz.shiqihao.effective.java.chapter05;

import java.util.ArrayList;
import java.util.List;

/**
 * 优先考虑使用List而不是数组.
 * 因为List支持泛型, 而数组不支持, 使用数组会失去编译时检查类型安全的好处.
 * Array is covariant(协变). List is invariant(不变).
 */
public class Item28 {
    public static void main(String[] args) {
        // Fails at runtime!
        Object[] objectArray = new Long[1];
        objectArray[0] = "str"; // Throws ArrayStoreException

        // Fails at compile time!
        List<Long> l = new ArrayList<>();
        //l.add("str") // Won't compile!
    }

    // List<String>[] stringList = new List<String>[1];
    // Generic array is illegal.
    List<Integer> list = new ArrayList<>(1);
}
