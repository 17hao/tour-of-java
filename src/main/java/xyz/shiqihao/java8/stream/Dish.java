package xyz.shiqihao.java8.stream;

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

    public enum  Type {
        FISH,
        MEAT,
        OTHER
    }
}