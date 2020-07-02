package xyz.shiqihao.advanced.jvm.classload.loading;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class MyTest3 {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        //System.out.println(classLoader);

        String resourceName = "xyz/shiqihao/advanced/jvm/classload/loading";
        Enumeration<URL> urls = classLoader.getResources(resourceName);
        while (urls.hasMoreElements()) {
            System.out.println(urls.nextElement());
        }

        System.out.println("===separator===");

        Class<?> myClazz  = MyTest3.class;
        System.out.println(myClazz.getClassLoader());
        Class<?> systemClazz = String.class;
        System.out.println(systemClazz.getClassLoader());
    }
}
