package xyz.shiqihao.advanced.reflection;

import com.google.common.reflect.ClassPath;
import xyz.shiqihao.advanced.reflection.resource.SuperInterface;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MyTest2 {
    public static void main(String[] args) throws IOException {
        MyTest2 m = new MyTest2();
        m.foo();
    }

    private void foo() throws IOException {
        String packageName = "xyz.shiqihao.advanced.reflection.code";
        String interfaceName = SuperInterface.class.getName();
        System.out.println("interface is: " + interfaceName);
        System.out.println("===");
        List<ClassPath.ClassInfo> classInfos = ClassPath.from(this.getClass().getClassLoader()).getTopLevelClasses(packageName).asList();
        classInfos.stream().map(ClassPath.ClassInfo::load)
                .map(Class::getGenericInterfaces)
                .flatMap(Arrays::stream)
                .filter(j -> j.getTypeName().equals(interfaceName))
                .forEach(t -> System.out.println(t.getTypeName()));
    }
}
