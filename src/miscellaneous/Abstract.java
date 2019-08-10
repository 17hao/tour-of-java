package miscellaneous;

public interface Abstract {
    int add(int m, int n);
}


abstract class AbstractClass {
    abstract int product(int m, int n);
}

class ConcreteClass extends AbstractClass implements Abstract {
    @Override
    public int add(int m, int n) {
        return m + n;
    }

    @Override
    int product(int m, int n) {
        return m * n;
    }

    public static void main(String[] args) {
        Abstract i = new ConcreteClass();
        AbstractClass c = new ConcreteClass();
        System.out.println(i.add(1, 1));
        System.out.println(c.product(3, 4));
    }
}
