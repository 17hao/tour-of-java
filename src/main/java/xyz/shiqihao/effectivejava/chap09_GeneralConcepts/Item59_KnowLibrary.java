package xyz.shiqihao.effectivejava.chap09_GeneralConcepts;

import java.util.Random;

public class Item59_KnowLibrary {
    // Common but deeply flawed
    private static Random rnd = new Random();

    // Generating random integers between 0 and some upper bound
    private static int random(int n) {
        return Math.abs(rnd.nextInt()) % n;
    }

    // Preferred way to generate random integers between 0 and upper bound
    private static int randomV2(int bound) {
        return Math.abs(rnd.nextInt(bound));
    }

    public static void main(String[] args) {
        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        for (int i = 0; i < 1000000; i++) {
            if (random(n) < n / 2) {
                low++;
            }
        }
        System.out.println(low);

        int lowV2 = 0;
        for (int i = 0; i < 1000000; i++) {
            if (randomV2(n) < n / 2) {
                lowV2++;
            }
        }
        System.out.println(lowV2);
    }
}
