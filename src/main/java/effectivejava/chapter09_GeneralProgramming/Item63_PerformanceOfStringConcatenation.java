package main.effectivejava.chapter09_GeneralProgramming;

public class Item63_PerformanceOfStringConcatenation {
    public static void main(String[] args) {
        // Inappropriate use of String concatenation - Performs poorly!
        String[] strings = {"h", "e", "l", "l", "o"};
        String result = "";
        for (String s : strings) {
            result += s;
        }
        System.out.println(result);

        StringBuilder b = new StringBuilder(strings.length);
        for (String s : strings) {
            b.append(s);
        }
        System.out.println(b);
    }
}
