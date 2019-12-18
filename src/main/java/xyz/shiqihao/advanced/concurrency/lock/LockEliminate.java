package xyz.shiqihao.advanced.concurrency.lock;

/**
 * java -XX:+DoEscapeAnalysis -XX:+EliminateLocks -Xcomp -XX:+BackgroundCompilation
 * -XX:BiasedLockingStartupDelay=0 -cp src/main/java
 * xyz.shiqihao.advanced.concurrency.lock.LockEliminate
 *
 * 使用以上命令开启锁消除. 如果不使用偏向锁(-XX:BiasedLockingStartupDelay=0)性能差距会更大.
 */
public class LockEliminate {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int count = 0;
        while (count++ < 200000) {
            createStringBuffer("s1", "s2");
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }

    private static String createStringBuffer(String s1, String s2) {
        StringBuffer sb = new StringBuffer();
        sb.append(s1);
        sb.append(s2);
        return sb.toString();
    }
}
