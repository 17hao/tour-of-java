package xyz.shiqihao.designpattern.structral.adapter;

/**
 * 1. 如何识别? 创建对象时在构造方法中传入一个对象, 在新对象中对传入对象的方法进行包装. 但是大型项目中一般不会
 * 手动创建对象, 都是交给依赖注入框架完成. 所以从对象的行为上识别这种模式: 一个类的方法包裹了另一个类的方法.
 * 2. 适配器模式的意义? 旧有接口的行为无法完全满足现有的新需求, 或者旧的类型和新需要的类型不匹配, 但是旧的方法
 * 还值得复用, 没必要将旧的完全推翻重写, 这时候可以用适配器模式. 在jdk中的使用: Arrays.asList(T...a)
 * java.io.InputStreamReader(InputStream)
 */
public class Client {
    public static void main(String[] args) {
        Plane plane = new ConcretePlane();
        Car car = new FlyCar(plane);
        System.out.println(car.drive());
    }
}
