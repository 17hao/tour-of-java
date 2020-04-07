package xyz.shiqihao.java8.stream;

import java.util.Arrays;
import java.util.List;

class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    String name() {
        return name;
    }

    boolean vegetarian() {
        return vegetarian;
    }

    int calories() {
        return calories;
    }

    Type type() {
        return type;
    }

    public enum Type {
        FISH,
        MEAT,
        OTHER
    }

    @Override
    public String toString() {
        return name;
    }

    static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));
}