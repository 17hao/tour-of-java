package xyz.shiqihao.designpattern.creational.abstractfactory.example_2;

/**
 * 抽象工厂模式.
 * 优点: 将客户端代码与创建对象的行为解耦.
 * 实现方式: 工厂制造类(generator/producer/manager)制造多个不同的工厂, 不同的工厂制造同一父类下不同子类的对象
 *
 * 注意区分静态工厂模式和抽象工厂模式, 静态工厂模式中调用类似getInstance()方法可以直接获得
 * 该类的实例. 抽象工厂模式围绕着一个制造工厂的类, 这个类是工厂的工厂, 它并不直接生产对象,
 * 通过它可以获得具体的工厂, 而且具体的工厂还能生产同一父类下不同子类的对象,
 */
public class Main {
    public static void main(String[] args) {
        AbstractFactory f1 = FactoryProducer.getFactory(false);
        Shape s1 = f1.getShape("RECTANGLE");
        s1.draw();

        AbstractFactory f2 = FactoryProducer.getFactory(true);
        Shape s2 = f2.getShape("SQUARE");
        s2.draw();
    }
}
