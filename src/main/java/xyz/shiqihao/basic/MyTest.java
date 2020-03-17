package xyz.shiqihao.basic;

public class MyTest {
    public static void main(String[] args) {
        String str = "string";
        System.out.println(str.hashCode());
        method(str);
    }

    static void method(String str) {
        str = str.toUpperCase();
        System.out.println(str.hashCode());
    }
}
