package etc;

public interface Abstract {
    int add(int m, int n);
}


abstract class AbstractClass {
    abstract int product(int m, int n);
}

class Concrete extends AbstractClass implements Abstract {
    @Override
    public int add(int m, int n) {
        return m + n;
    }

    @Override
    int product(int m, int n) {
        return m * n;
    }

    public static void main(String[] args) {
        Abstract i = new Concrete();
        AbstractClass c = new Concrete();
        System.out.println(i.add(1, 1));
        System.out.println(c.product(3, 4));
    }
}
