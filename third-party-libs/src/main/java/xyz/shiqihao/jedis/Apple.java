package xyz.shiqihao.jedis;

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
}
