package xyz.shiqihao.thinking.in.java.chap18_io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {
    public static void main(String[] args) {
        File file = new File("./src/ThinkingInJava.chapter14_typeinfo");
        String[] list;
        if (args.length == 0) {
            list = file.list();
        } else {
            list = file.list(new DirFilter(args[0]));
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String s : list) {
            System.out.println(s);
        }
    }
}

class DirFilter implements FilenameFilter {
    private Pattern pattern;

    DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
