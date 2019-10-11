package xyz.shiqihao.jvm.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class MyTest5 {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        //System.out.println(classLoader);

        String resourceName = "xyz/shiqihao/jvm/classloader";
        Enumeration<URL> urls = classLoader.getResources(resourceName);
        while (urls.hasMoreElements()) {
            System.out.println(urls.nextElement());
        }

        System.out.println("===separator===");

        Class<?> myClazz  = MyTest5.class;
        System.out.println(myClazz.getClassLoader());
        Class<?> systemClazz = String.class;
        System.out.println(systemClazz.getClassLoader());
    }
}
