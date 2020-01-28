package xyz.shiqihao.designpattern.creational.abstractfactory.example_2;

public class ShapeFactory implements AbstractFactory {
    @Override
    public Shape getShape(String type) {
        if (type.equals("RECTANGLE")) {
            return new Rectangle();
        } else if (type.equals("SQUARE")) {
            return new Square();
        }
        return null;
    }
}
