package xyz.shiqihao.advanced.jvm.classload.loading;

/**
 * output:
 * sun.misc.Launcher$AppClassLoader@2a139a55
 * sun.misc.Launcher$ExtClassLoader@7852e922
 * null
 *
 * 双亲委派模式的委派路径: 应用类加载器 -> 扩展类加载器 -> bootstrap类加载器
 */
public class MyTest2 {
    public static void main(String[] args) {
        ClassLoader classLoader  = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        while (classLoader != null) {
            classLoader = classLoader.getParent();
            System.out.println(classLoader);
        }
    }
}
