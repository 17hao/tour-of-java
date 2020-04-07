package xyz.shiqihao.advanced.jvm.classfile;

/**
 *
 */
public class StringIntern {
    public static void main(String[] args) {
        String a = Integer.toString(1) + Integer.toString(2) + Integer.toString(3);
        String b = "123";
        String c = "123";
        String d = Integer.toString(123);
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(a.intern() == b);
        System.out.println("===");
        System.out.println(b == c);
        System.out.println(b == d);
        System.out.println("=== String intern ===");
        System.out.println(a.intern());
    }
}
