package xyz.shiqihao.java8.functional;

import java.io.File;
import java.io.FileFilter;

public class FilterHiddenFiles {
    public static void main(String[] args) {
        for (File file : hiddenFilesFunctional()) {
            System.out.println(file);
        }
    }

    static File[] hiddenFiles() {
        return new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });
    }

    static File[] hiddenFilesFunctional() {
        return new File(".").listFiles(File::isHidden);
    }
}
