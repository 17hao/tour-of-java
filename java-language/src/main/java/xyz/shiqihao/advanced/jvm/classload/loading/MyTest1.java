package xyz.shiqihao.advanced.jvm.classload.loading;

import java.io.IOException;
import java.io.InputStream;

/**
 * 用自定义的类加载器加载这个测试类, 此时jvm中存在2个MyTest1类, 一个由自定义的类加载器加载,
 * 另一个由虚拟机应用程序类加载加载, 这2个类虽然class文件相同, 但是不是相同的类.
 */
public class MyTest1 {
    public static void main(String[] args) throws Exception {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String filename = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(filename);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    int len = is.read(b);
                    return defineClass(name, b, 0, len);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myLoader.loadClass("xyz.shiqihao.advanced.jvm.classload.loading.MyTest1").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof MyTest1);
    }
}
