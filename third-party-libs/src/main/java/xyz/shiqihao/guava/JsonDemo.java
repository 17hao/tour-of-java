package xyz.shiqihao.guava;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonDemo {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("a");
        l.add("b");
        String json = new Gson().toJson(l);
        System.out.println(json);
        Map<String, String> map = new HashMap<>();
        map.put("k", "v");
        System.out.println(new Gson().toJson(map));
    }
}
