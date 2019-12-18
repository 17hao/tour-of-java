package xyz.shiqihao.advanced.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * java -Xmx20m -Xms5m -XX:+HeapDumpOnOutOfMemoryError
 * -XX:HeapDumpPath=./a.dump xyz/shiqihao/advanced/jvm/DumpOOM
 */
public class DumpOOM {
    public static void main(String[] args) {
        List<byte[]> l = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            l.add(new byte[1024 * 1025]);
        }
    }
}
