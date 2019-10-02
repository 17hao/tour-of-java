package xyz.shiqihao.misc;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        String text = "hi${1}, you have a ${2}.";
        Pattern pattern = Pattern.compile("\\{(.*?)\\}");
        Matcher matcher = pattern.matcher(text);
        ArrayList<String> list = new ArrayList<>();
        while (matcher.find()) {
            String s = text.substring(matcher.start(), matcher.end());
            list.add(s);
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}
