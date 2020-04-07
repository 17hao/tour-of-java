package xyz.shiqihao.effective.java.chapter03;

import java.util.Objects;

/**
 * Obey the general contact when overriding equals.
 *
 * equals方法遵循的规则:
 * 1. 在以下情况下最好不要重写equals方法
 *   a. 类的每个实例从内在上看是相等的. Thread类是最好的例子.
 *   b. 类从逻辑上来看没必要提'相等'这个概念. 比如java.util.regex.Pattern
 *   c. 父类已经重写了equals方法, 并且子类的行为和父类一致.
 *   d. 类是私有的或包私有的, 并且它的equals方法永远不会被调用.
 * 2. 自反性 x.equals(x)必须返回true
 * 3. 对称性 x.equals(y) == y.equals(x)
 * 4. 传递性 x.equals(y) == true; y.equals(z) == true; x.equals(z) == true
 * 5. 一致性 多次调用x.equals(y)返回的值必须一样
 * 6. x.equals(null) 必须返回false
 */
public class Item10 {
    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Point");
        String s = "point";
        System.out.println(cis.equals(s));
        System.out.println(s.equals(cis));
    }

    final static class CaseInsensitiveString {
        private final String s;

        CaseInsensitiveString(String s) {
            this.s = Objects.requireNonNull(s);
        }

        // Broken! violate symmetry
        // @Override
        // public boolean equals(Object obj) {
        //     if (obj instanceof CaseInsensitiveString) {
        //         return s.equalsIgnoreCase(((CaseInsensitiveString) obj).s);
        //     }
        //     if (obj instanceof String) {
        //         return s.equalsIgnoreCase((String) obj);
        //     }
        //     return false;
        // }


        @Override
        public boolean equals(Object obj) {
            return obj instanceof CaseInsensitiveString && ((CaseInsensitiveString) obj).s.equalsIgnoreCase(s);
        }
    }
}
