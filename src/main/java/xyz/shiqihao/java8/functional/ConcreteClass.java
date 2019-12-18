package xyz.shiqihao.java8.functional;

public class ConcreteClass implements DefaultMethod {
    public static void main(String[] args) {
        ConcreteClass c = new ConcreteClass();
        System.out.println(c.defaultMethod());
        System.out.println(DefaultMethod.defaultStaticMethod());
        System.out.println(c.abstractMethod());
    }

    @Override
    public String abstractMethod() {
        return "abstract method";
    }
}
