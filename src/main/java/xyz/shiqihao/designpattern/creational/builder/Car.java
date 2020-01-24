package xyz.shiqihao.designpattern.creational.builder;

public class Car {
    private final String color;
    private final String engine;
    private final String brand;
    private final double price;

    private Car(Builder builder) {
        color = builder.color;
        engine = builder.engine;
        brand = builder.brand;
        price = builder.price;
    }

    public static class Builder {
        private final String engine;
        private final String brand;

        private String color = "";
        private double price = -1;

        public Builder(String engine, String brand) {
            this.brand = brand;
            this.engine = engine;
        }

        Builder color(String val) {
            color = val;
            return this;
        }

        Builder price(double val) {
            price = val;
            return this;
        }

        Car build() {
            return new Car(this);
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", engine='" + engine + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
