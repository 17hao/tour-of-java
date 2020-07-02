// package xyz.shiqihao.basic.generic;
//
// import java.lang.reflect.Array;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Collection;
// import java.util.List;
//
// public class Test1 {
//     @Deprecated
//     static void fromArrayToCollection(Object[] a, Collection<Object> c) {
//         c.addAll(Arrays.asList(a));
//     }
//
//     static <T> void fromArrToCollection(T[] a, Collection<T> c) {
//         c.addAll(Arrays.asList(a));
//     }
//
//     static <T> T[] convert(List<T> l, Class<T> c) {
//         return (T[])Array.newInstance(c, l.size());
//     }
//
//     public static void main(String[] args) {
//         List<String> l1 = new ArrayList<>();
//         List<String> l2 = new ArrayList<>();
//         List<?>[] a = {l1, l2};
//         Collection<List<?>> c = new ArrayList<>();
//         // fromArrayToCollection(a, c); // Compile time error!
//         fromArrToCollection(a, c);
//
//         boolean isObject = Collection.class.isAssignableFrom(Object.class);
//         System.out.println(isObject); // false
//
//
//         String[] strings = convert(l1, String.class);
//         System.out.println(Arrays.toString(strings));
//     }
// }
//
package xyz.shiqihao.basic.generic;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Test1 {
    static <T> T[] convert(List<T> l, Class<T> c) {
        return (T[]) Array.newInstance(c, l.size());
    }

    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("a");
        l.add("b");
        String[] strings = convert(l, String.class);
        System.out.println(Arrays.toString(strings));
    }
}
