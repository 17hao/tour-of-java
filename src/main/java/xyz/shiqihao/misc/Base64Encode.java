package xyz.shiqihao.misc;

import java.util.Base64;

/**
 * Encode string to Base64.
 */
public class Base64Encode {
    public static void main(String[] args) {
        System.out.println(new String(encode()));
    }

    private static byte[] encode() {
        return Base64.getEncoder().encode("hello, world\n".getBytes());
    }
}
