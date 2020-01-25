package xyz.shiqihao.effectivejava.chap02;

/**
 * Consider a builder when faced with many constructor parameters.
 */
public class Item02 {
    public static void main(String[] args) {
        Car smart = new Car.Builder("Benz", "v1").color("green").build();
        Car customize = new Car.Builder("Benz", "v8").color("red").license(666).build();
        System.out.println(smart + "\n" + customize);
    }

    final static class Car {
        private final String brand;
        private final String engine;
        private final String color;
        private final int license;

        public static class Builder {
            // Required parameters
            private final String brand;
            private final String engine;

            // Optional parameters
            private String color = "black";
            private int license = -1;

            public Builder(String brand, String engine) {
                this.brand = brand;
                this.engine = engine;
            }

            Builder color(String val) {
                color = val;
                return this;
            }

            Builder license(int val) {
                license = val;
                return this;
            }

            public Car build() {
                return new Car(this);
            }
        }

        private Car(Builder builder) {
            brand = builder.brand;
            engine = builder.engine;
            color = builder.color;
            license = builder.license;
        }

        @Override
        public String toString() {
            return brand + " " + color + " " + engine + " " + license;
        }
    }
}
