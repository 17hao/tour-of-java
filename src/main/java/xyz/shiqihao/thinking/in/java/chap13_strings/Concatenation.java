package xyz.shiqihao.thinking.in.java.chap13_strings;

public class Concatenation {
    public static void main(String[] args) {
        String str = "mango";
        String res = str + " def " + " 10"; // 编译器创建多个StringBuilder
        System.out.println(res);
    }
}
