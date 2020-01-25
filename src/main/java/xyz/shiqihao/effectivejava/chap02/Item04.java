package xyz.shiqihao.effectivejava.chap02;

/**
 * Noninstantiable utility class.
 */
public class Item04 {
}

class Tool {
    static int sum(int a, int b) {
        return a + b;
    }

    static final String sign = "sign";

    /**
     * suppress default constructor for noninstantiability
     */
    private Tool() {
    }
}
