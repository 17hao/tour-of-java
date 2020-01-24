package xyz.shiqihao.advanced.jvm.classload.initializing;

/**
 * output:
 * parent class
 * hello, world
 *
 * 子类调用父类的静态字段会加载子类但不会初始化子类, 只会初始化父类.
 * 只有直接读取或设置这个类的静态字段才会导致初始化(final修饰的常量除外).
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