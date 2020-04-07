package xyz.shiqihao.advanced.jvm.classload.initializing;

/**
 * output: hello, world
 *
 * The constant 'STR' is in the constant pool of MyTest2
 */
public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(Parent2.STR);
    }
}

class Parent2 {
    static final String STR = "hello, world";

    static {
        System.out.println("I am Parent2");
    }
}