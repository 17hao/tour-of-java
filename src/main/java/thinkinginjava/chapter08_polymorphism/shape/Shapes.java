package thinkinginjava.chapter08_polymorphism.shape;

/**
 * RandomShapeGenerator随机返回Shape类型的对象
 * 编译器需要知道应该调用哪一个具体的子类对象
 * 这依赖于动态绑定的机制
 * 在对象中内置了存储对象信息的结构
 */
public class Shapes {
    private static RandomShapeGenerator gen = new RandomShapeGenerator();

    public static void main(String[] args) {
        Shape[] s = new Shape[10];
        for (int i = 0; i < s.length; i++) {
            s[i] = gen.next();
        }
        for (Shape shape : s) {
            shape.draw();
        }
    }
}
