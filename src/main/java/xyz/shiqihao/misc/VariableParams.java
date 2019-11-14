package xyz.shiqihao.misc;

import java.util.ArrayList;
import java.util.List;

public class VariableParams {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        String[] ss = new String[l.size()];
        for (Integer i : l) {
            ss[l.indexOf(i)] = String.valueOf(i);
        }
        String result = varargs(ss);
        System.out.println(result);
    }

    private static String varargs(String... params) {
        StringBuilder sb = new StringBuilder();
        for (String s : params) {
            sb.append(s);
        }
        return sb.toString();
    }
}
