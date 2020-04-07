package xyz.shiqihao.java8.functional;

@FunctionalInterface
public interface DefaultMethod {
    String abstractMethod();

    default String defaultMethod() {
        return "this is a default method in interface";
    }

    static String defaultStaticMethod() {
        return "this is a static method in interface";
    }
}
