package xyz.shiqihao.thinkinginjava.chapter18_io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class DirList3 {
    public static void main(String[] args) {
        File file = new File(".");
        String[] list;
        if (args.length == 0) {
            list = file.list();
        } else {
            list = file.list(new FilenameFilter() {
                Pattern pattern = Pattern.compile(args[0]);

                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}
