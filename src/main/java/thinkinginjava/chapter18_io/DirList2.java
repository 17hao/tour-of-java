package thinkinginjava.chapter18_io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList2 {
    private static FilenameFilter filenameFilter(final String regex) {
        // creation of anonymous inner class
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);

            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        }; // end of anonymous inner class
    }

    public static void main(String[] args) {
        File file = new File(".");
        String[] list;
        if (args.length == 0) {
            list = file.list();
        } else {
            list = file.list(filenameFilter(args[0]));
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
