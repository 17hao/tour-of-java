package xyz.shiqihao.java8;

class Apple {
    private final String color;
    private final int heavy;

    Apple(String color, int heavy) {
        this.color = color;
        this.heavy = heavy;
    }

    String color() {
        return color;
    }

    int heavy() {
        return heavy;
    }

    @Override
    public String toString() {
        return "color is: " + color + ", heavy is: " + heavy;
    }
}
