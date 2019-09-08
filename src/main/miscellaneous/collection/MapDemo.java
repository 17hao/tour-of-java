package main.miscellaneous.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapDemo {
    private static Map<String, String> hashMap = new HashMap<>();

    public static void main(String[] args) {
        String res = hashMap.put("k1", "v1");
        System.out.println(res);
        String newRes = hashMap.put("k1", "new_v1");
        System.out.println(newRes);
        boolean test = hashMap instanceof TreeMap;
        System.out.println(test);
    }
}
