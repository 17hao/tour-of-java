package xyz.shiqihao.advanced.jvm.classload;

/**
 * output:
 * sun.misc.Launcher$AppClassLoader@2a139a55
 * sun.misc.Launcher$ExtClassLoader@7852e922
 * null
 *
 * 应用类加载器 -> 扩展类加载器 -> bootstrap类加载器
 */
public class MyTest4 {
    public static void main(String[] args) {
        ClassLoader classLoader  = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        while (classLoader != null) {
            classLoader = classLoader.getParent();
            System.out.println(classLoader);
        }
    }
}
