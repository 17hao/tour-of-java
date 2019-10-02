package xyz.shiqihao.misc;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class JsonDemo {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("a");
        l.add("b");
        String json = new Gson().toJson(l);
        System.out.println(json);
    }
}
