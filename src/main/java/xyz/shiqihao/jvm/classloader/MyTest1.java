package xyz.shiqihao.jvm.classloader;

/**
 * output:
 * parent class
 * hello, world
 */
public class MyTest1 {
    public static void main(String[] args) {
        System.out.println(Child1.str);
    }
}

class Parent1 {
    static String str = "hello, world";

    static {
        System.out.println("parent class");
    }
}

class Child1 extends Parent1 {
    static {
        System.out.println("child class");
    }
}