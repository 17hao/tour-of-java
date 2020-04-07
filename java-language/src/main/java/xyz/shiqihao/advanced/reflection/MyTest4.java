package xyz.shiqihao.advanced.reflection;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * invokeExact和invoke的区别:?
 */
public class MyTest4 {
    public static void main(String[] args) {
        try {
            Object hashids = HashIds.HASHIDS.invokeExact("salt", 16);
            System.out.println(hashids.getClass());
            String res = (String) hashids.getClass().getDeclaredMethod("encode", long[].class).invoke(hashids.getClass().newInstance(), new long[]{2L});
            System.out.println(res);
//            String res = (String) HashIds.ENCODE.invoke(1L);
//            System.out.println(res);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static class HashIds {
        static MethodHandle HASHIDS = getHashIds();
        static MethodHandle ENCODE = getEncode();
    }

    private static MethodHandle getHashIds() {
        try {
            return MethodHandles
                    .publicLookup()
                    .findConstructor(Class.forName("org.hashids.Hashids"),
                            MethodType.methodType(void.class, String.class, int.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static MethodHandle getEncode() {
        try {
            return MethodHandles
                    .publicLookup()
                    .findVirtual(Class.forName("org.hashids.Hashids"), "encode",
                            MethodType.methodType(String.class, long[].class))
                    .asVarargsCollector(long[].class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
