package xyz.shiqihao.designpattern.creational.abstractfactory.example_2;

public class RoundedShapeFactory implements AbstractFactory {
    @Override
    public Shape getShape(String type) {
        if (type.equals("RECTANGLE")) {
            return new RoundedRectangle();
        } else if (type.equals("SQUARE")) {
            return new RoundedSquare();
        }
        return null;
    }
}
