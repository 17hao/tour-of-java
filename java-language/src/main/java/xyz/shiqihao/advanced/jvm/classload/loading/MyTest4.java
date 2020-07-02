package xyz.shiqihao.advanced.jvm.classload.loading;

/**
 * 第一个null代表bootstrap classloader
 * 第三个null代表没有类加载器. 数组类型不是由类加载器加载进jvm的, 而是由jvm调用newarray指令生成的.
 */
public class MyTest4 {
    public static void main(String[] args) {
        String[] strings = new String[2];
        System.out.println(strings.getClass().getClassLoader()); // ①

        MyTest4[] tests = new MyTest4[2];
        System.out.println(tests.getClass().getClassLoader()); // ②

        int[] ints = new int[2];
        System.out.println(ints.getClass().getClassLoader()); // ③

        Integer[] integers = new Integer[2];
        System.out.println(integers.getClass().getClassLoader()); // ④
    }
}
