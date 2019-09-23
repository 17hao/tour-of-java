package xyz.shiqihao.thinkinginjava.chapter13_strings;

public class Immutable {
    /* String所有的方法都是返回一个新的String对象，这是String保证是不可变的重要手段 */
    private static String upcase(String str) {
        return str.toUpperCase();
    }

    public static void main(String[] args) {
        String str = "asdf";
        System.out.println(str);
        String string = upcase(str);
        System.out.println(string);
    }
}
