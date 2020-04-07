package xyz.shiqihao.advanced.reflection;

import xyz.shiqihao.advanced.reflection.resource.E;

import java.util.HashSet;
import java.util.Set;

/**
 * 反射的入口是java.lang.Class的对象.
 * java中的类型分为2大类, 一类是引用类型(reference), 另一类是原始类型(primitive).
 * 应用类型包括class, interface, enum, array(继承自java.lang.Object).
 * 基本类型包括8种: boolean, byte, int, short, long, char, float, double.
 * <p>
 * 对于引用类型, 通常的做法是通过类型实例化后的对象调用Object.getClass()获取Class类的实例.
 * 对于没有实例的类型, 包括基本类型, 通过class关键字获取Class类的实例.
 */
public class MyTest1 {
    public static void main(String[] args) throws ClassNotFoundException {
        byte[] bytes = new byte[1024];
        System.out.println(bytes.getClass()); // class [B

        Class<?> c = E.A.getClass();
        System.out.println(c); // class xyz.shiqihao.advanced.reflection.E

        Set<Integer> set = new HashSet<>(); // class java.util.HashSet
        System.out.println(set.getClass());

        boolean b;
        System.out.println(boolean.class); // b.class compile-time error
        System.out.println(java.io.PrintStream.class);

        System.out.println(Class.forName("org.postgresql.Driver"));
    }
}
