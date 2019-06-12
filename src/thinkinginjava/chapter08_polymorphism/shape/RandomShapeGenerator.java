package thinkinginjava.chapter08_polymorphism.shape;

import java.util.Random;

class RandomShapeGenerator {
    private Random n = new Random(47);

    Shape next() {
        switch (n.nextInt(3)) {
            default:
            case 0:
                return new Circle();
            case 1:
                return new Square();
            case 2:
                return new Triangle();
        }
    }
}
