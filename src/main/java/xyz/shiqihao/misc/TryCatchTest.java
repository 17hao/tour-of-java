package xyz.shiqihao.misc;

public class TryCatchTest {
    public static void main(String[] args) {
        System.out.println(rightOrErrorMsg());
    }

    private static String rightOrErrorMsg() {
        try {
            int num = 1 + 1;
            return String.valueOf(num);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
