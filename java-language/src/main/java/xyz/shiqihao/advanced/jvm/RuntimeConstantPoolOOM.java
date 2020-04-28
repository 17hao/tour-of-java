package xyz.shiqihao.advanced.jvm;

import java.util.HashSet;
import java.util.Set;

/**
 * JVM Args: -Xmx6m -XX:+PrintGCDetails -Xloggc:./gc.log -XX:+PrintGCDateStamps
 * -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./a.dump
 *
 * String.intern()方法: 如果常量池中已经有了该String对象, 直接返回; 否则创建一个新的.
 * jdk1.7开始字符串常量池从永久代移到了堆
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        int i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }
}
