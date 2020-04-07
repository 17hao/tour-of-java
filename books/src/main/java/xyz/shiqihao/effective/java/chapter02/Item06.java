package xyz.shiqihao.effective.java.chapter02;

import java.util.regex.Pattern;

/**
 * Avoid create unnecessary objects.
 */
public class Item06 {
    /**
     * We don't use `new` to create a String object.
     * Because the String literal is interned in JVM.
     * String a = "abc", b = "abc";
     * a == b is True
     * String a = new String("a"), b = new String("a");
     * a == b is False
     */

    // DON'T DO THIS!
    String s = new String("str");

    // Unnecessary boxing/unboxing operations!
    long sum() {
        //Long sum = 0L;
        long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }

    // Performance can be greatly improved!
    boolean isValid(String s) {
        return s.matches("^0-9$");
    }

    // Reusing expensive object for improving performance.
    private static final Pattern tmp = Pattern.compile("^0-9$");

    boolean isValidV2(String s) {
        return tmp.matcher(s).matches();
    }
}
