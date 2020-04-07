package xyz.shiqihao.basic.collection;

import java.util.*;

/**
 * different kinds of sets.
 */
public class MyTest3 {
    // Store elements in HashMap's key set.
    private final Set<String> hashSet = new HashSet<>();

    // The elements are ordered using their natural ordering or by a comparator provided.
    private Set<String> treeSet = new TreeSet<>();

    // Insertion order.
    private Set<String> linkedHashSet = new LinkedHashSet<>();
    private Random random = new Random();

    void hashSet() {
        hashSet.add("a");
        hashSet.add("1");
        hashSet.add("c");
        hashSet.add("2");
        hashSet.add("e");
        hashSet.forEach(x -> System.out.print(x + " "));
    }

    void treeSet() {
        treeSet.add("a");
        treeSet.add("1");
        treeSet.add("c");
        treeSet.add("2");
        treeSet.add("e");
        treeSet.forEach(x -> System.out.print(x + " "));
    }

    void linkedHashSet() {
        linkedHashSet.add("a");
        linkedHashSet.add("1");
        linkedHashSet.add("c");
        linkedHashSet.add("2");
        linkedHashSet.add("e");
        linkedHashSet.forEach(x -> System.out.print(x + " "));
    }

    public static void main(String[] args) {
        MyTest3 demo = new MyTest3();
        System.out.print("HashSet: ");
        demo.hashSet();
        System.out.print("\nTreeSet: ");
        demo.treeSet();
        System.out.print("\nLinkedHashMap: ");
        demo.linkedHashSet();
    }
}
