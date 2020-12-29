package xyz.shiqihao.basic;

public class StringUtil {
    private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String convert(String s) {
        int id = Integer.parseInt(s);
        StringBuilder builder = new StringBuilder();
        while (id >= 62) {
            builder.append(BASE62.charAt(id % 62));
            id /= 62;
        }
        if (id != 0) builder.append(BASE62.charAt(id));
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("62"));
        System.out.println(convert("1000"));
        System.out.println(convert("10000"));
        System.out.println(convert(String.valueOf(Integer.MAX_VALUE)));
    }
}
