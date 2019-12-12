package xyz.shiqihao.advanced.jvm.classload;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Customize class loader
 */
public class MyTest7 extends ClassLoader {
    private String classLoaderName;

    private final String fileExtension = ".class";

    MyTest7(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }

    MyTest7(ClassLoader parent, String classLoaderName) {
        super(parent); // 显示指定父加载器
        this.classLoaderName = classLoaderName;
    }

    @Override
    public String toString() {
        return "[" + this.classLoaderName + "]";
    }

    @Override
    protected Class<?> findClass(String name) {
        byte[] data = loadClassData(name);
        return defineClass(name, data, 0, data.length);
    }

    private byte[] loadClassData(String name) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream outputStream = null;

        try {
            this.classLoaderName = this.classLoaderName.replace(".", "\\");

            is = new FileInputStream(new File(name + fileExtension));
            outputStream = new ByteArrayOutputStream();
            int ch;
            while ((ch = is.read()) != 0) {
                outputStream.write(ch);
            }

            data = outputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert is != null;
                is.close();
                assert outputStream != null;
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    public static void test(ClassLoader classLoader) throws Exception {
        Object object = classLoader.loadClass("xyz.shiqihao.advanced.jvm.classload.MyTest1").newInstance();
        System.out.println(object);
    }

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = new MyTest7("customize class loader");
        test(classLoader);
    }
}
