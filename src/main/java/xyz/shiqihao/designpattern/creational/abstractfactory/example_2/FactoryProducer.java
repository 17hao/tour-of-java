package xyz.shiqihao.designpattern.creational.abstractfactory.example_2;

public class FactoryProducer {
    static AbstractFactory getFactory(boolean rounded) {
        if (rounded) {
            return new RoundedShapeFactory();
        } else {
            return new ShapeFactory();
        }
    }
}
