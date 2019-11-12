package xyz.shiqihao.misc;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class LengthOfChar {
    public static void main(String[] args) {
        String str = "str"; // char[3]
        System.out.println(str.getBytes(StandardCharsets.UTF_16).length); // 8
        System.out.println(str.getBytes(StandardCharsets.UTF_8).length); // 3
        System.out.println(str.getBytes().length); // 3
        System.out.println("===");
        String string = "string"; // char[6]
        System.out.println(string.getBytes(StandardCharsets.UTF_16).length); // 14
        System.out.println(string.getBytes(StandardCharsets.UTF_8).length); // 6
        System.out.println(string.getBytes().length); // 6
        System.out.println("===");
        String c = "鲸";
        System.out.println(c.getBytes(StandardCharsets.UTF_16).length); // 4
        System.out.println(c.getBytes(StandardCharsets.UTF_8).length); // 3

        Map<String, String> m = new HashMap<>();
        m.put("1", "2");
        m.put("3", "4");
        System.out.println(m.toString());
    }
}
