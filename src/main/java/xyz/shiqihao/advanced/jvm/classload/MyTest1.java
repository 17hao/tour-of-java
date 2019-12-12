package xyz.shiqihao.advanced.jvm.classload;

/**
 * output:
 * parent class
 * hello, world
 *
 * 子类调用父类的静态字段会加载子类但不会初始化子类,只会初始化父类.
 * java -XX:+TraceClassLoading
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