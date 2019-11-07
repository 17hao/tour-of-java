package xyz.shiqihao.java8.part_03;

public interface DefaultMethod {
    default String defaultMethod() {
        return "this is a default method in interface";
    }

    static String defaultStaticMethod() {
        return "this is a static method in interface";
    }
}
