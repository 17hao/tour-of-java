package xyz.shiqihao.jvm.classloader;

/**
 * output: hello, world
 * the constant str is in the constant_pool of MyTest2
 */
public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(Parent2.str);
    }
}

class Parent2 {
    static final String str = "hello, world";

    static {
        System.out.println("I am Parent2");
    }
}