// package xyz.shiqihao.basic.generic;
//
// import java.util.ArrayList;
// import java.util.Collection;
// import java.util.Collections;
//
// public class Test2 {
//     public static void main(String[] args) {
//         Collection<String> ls = new ArrayList<>();
//
//         Collection<Object> lo = Collections.singleton(ls);
//
//         ls.add("a");
//         for (Object o : lo) {
//             System.out.println(o);
//         }
//
//
//         System.out.println("=====");
//         ls.add("b");
//         for (Object o : lo) {
//             System.out.println(o);
//         }
//
//     }
// }
package xyz.shiqihao.basic.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Test2 {
    public static void main(String[] args) {
        List<String> l = method();
        Type t = l.getClass().getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            Type actualType = ((ParameterizedType) t).getActualTypeArguments()[0];
            System.out.println(actualType.getTypeName());
        }
    }

    static <T> List<T> method() {
        return new ArrayList<>();
    }
}