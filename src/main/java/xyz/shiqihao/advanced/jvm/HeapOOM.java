package xyz.shiqihao.advanced.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * JVM args: -Xms5m -Xmx20m -XX:+HeapDumpOutOfMemoryError -XX:HeapDumpPath=./a.dump
 *
 * 排查堆内存oom的简要步骤: 常规方法是通过内存dump文件进行分析. 首先确定是内存泄露(memory leak)还是
 * 内存溢出(memory overflow). 如果是内存泄露, 意味着有部分对象应该被垃圾回收, 但是程序中还保留着它们的引用,
 * 导致无法正常gc. 这时候要对泄露对象进行可达性分析, 即它们通过什么路径与哪些GC Roots相关联. 如果是内存溢出,
 * 意味着堆中的对象是应该存活的, 这时候可以分两步 (1)检查jvm参数, 是否可以上调堆的大小. (2)检查代码, 看看
 * 是否有对象存活时间过长, 对象属性的存储结构是否合理.
 */
public class HeapOOM {
    public static void main(String[] args) {
        List<byte[]> l = new ArrayList<>();
        while (true) {
            l.add(new byte[1024 * 1024]);
        }
    }
}
