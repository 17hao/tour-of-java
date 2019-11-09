package xyz.shiqihao.advanced.jvm.classloader;

public class MyTest3 {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());

        Class<?> clazz2 = Class.forName("xyz.shiqihao.advanced.jvm.classloader.C");
        System.out.println(clazz2.getClassLoader());
    }
}

class C {

}
