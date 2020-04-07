package xyz.shiqihao.advanced.jvm.classload.loading;

/**
 * output:
 * null
 * sun.misc.Launcher$AppClassLoader@2a139a55
 * <p>
 * <JAVA_HOME/lib>目录下的类由bootstrap类加载器加载,
 * 自定义的类由应用类加载器加载
 */
public class MyTest6 {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());

        Class<?> clazz2 = Class.forName("xyz.shiqihao.advanced.jvm.classload.loading.MyTest6.C");
        System.out.println(clazz2.getClassLoader());
    }
}

class C {

}
