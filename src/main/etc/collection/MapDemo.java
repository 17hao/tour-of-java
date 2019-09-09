package main.etc.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapDemo {
    private Map<String, String> hashMap = new HashMap<>();
    private Map<String, String> treeMap = new TreeMap<>();
    private Map<String, String> linkedHashMap = new LinkedHashMap<>();

    public static void main(String[] args) {
        MapDemo demo = new MapDemo();

        String res = demo.hashMap.put("k1", "v1");
        System.out.println(res);
        String newRes = demo.hashMap.put("k1", "new_v1");
        System.out.println(newRes);
        demo.hashMap.put(null, "null");
        System.out.println("HashMap: " + demo.hashMap);

        demo.treeMap.put("null", "null"); // It does not permit null keys.
        demo.treeMap.put("k1", "v1");
        System.out.println("TreeMap: " + demo.treeMap);

        demo.linkedHashMap.put(null, "null");
        System.out.println("LinkedHashMap: " + demo.linkedHashMap);
    }
}
