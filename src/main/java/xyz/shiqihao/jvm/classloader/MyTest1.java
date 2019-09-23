package xyz.shiqihao.jvm.classloader;

public class MyTest1 {
    public static void main(String[] args) {
        System.out.println(Child.str);
    }
}

class Parent {
    static String str = "hello, world";

    static {
        System.out.println("parent class");
    }
}

class Child extends Parent {
    static {
        System.out.println("child class");
    }
}