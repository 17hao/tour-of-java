package xyz.shiqihao.java8.functional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AppleMain {
    public static void main(String[] args) {
        Apple apple1 = new Apple("green", 10);
        Apple apple2 = new Apple("green", 11);
        Apple apple3 = new Apple("red", 9);
        List<Apple> inventory = new ArrayList<>();
        inventory.add(apple1);
        inventory.add(apple2);
        inventory.add(apple3);
        for (Apple apple : filterApple(inventory, AppleMain::isGreenApple)) {
            System.out.println(apple);
        }

        // Using lambda.
        for (Apple apple : filterApple(inventory, a -> a.weight() < 10)) {
            System.out.println(apple);
        }

        // Using stream.
        for (Apple apple : inventory.stream().filter((apple -> apple.weight() < 10)).collect(Collectors.toList())) {
            System.out.println(apple);
        }

        // Compare element by parameterize action.
        inventory.sort(Comparator.comparingInt(Apple::weight));
        for (Apple apple : inventory) {
            System.out.println(apple);
        }
    }

    /**
     * Traditional way to filter something.
     */
    static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.color().equals("green")) {
                result.add(apple);
            }
        }
        return result;
    }

    static List<Apple> filterLightApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.weight() < 10) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * Passing function as parameter.
     */
    static List<Apple> filterApple(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    static boolean isGreenApple(Apple apple) {
        return apple.color().equals("green");
    }

    static boolean isLightApple(Apple apple) {
        return apple.weight() < 10;
    }
}
