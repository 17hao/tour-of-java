package xyz.shiqihao.effectivejava.chap03_MethodsInObject;

import java.util.Objects;

public class Item10_ObeyEqualsContract {
    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Point");
        String s = "point";
        System.out.println(cis.equals(s));
        System.out.println(s.equals(cis));
    }
}

final class CaseInsensitiveString {
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
