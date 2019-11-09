package xyz.shiqihao.java8.functional;

class Apple {
    private final String color;
    private final int weight;

    Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    String color() {
        return color;
    }

    int weight() {
        return weight;
    }

    @Override
    public String toString() {
        return "color is: " + color + ", heavy is: " + weight;
    }
}
