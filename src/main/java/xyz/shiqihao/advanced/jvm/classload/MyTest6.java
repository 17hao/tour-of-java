package xyz.shiqihao.advanced.jvm.classload;

/**
 * 第一个null代表bootstrap class loader
 * 第三个null 代表没有类加载器
 */
public class MyTest6 {
    public static void main(String[] args) {
        String[] strings = new String[2];
        System.out.println(strings.getClass().getClassLoader());

        System.out.println("----------------");

        MyTest6[] myTest6s = new MyTest6[2];
        System.out.println(myTest6s.getClass().getClassLoader());

        System.out.println("----------------");

        int[] ints = new int[2];
        System.out.println(ints.getClass().getClassLoader());
    }
}
