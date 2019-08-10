package miscellaneous;

abstract class Func implements base {
    abstract int add(int n, int m);
}

interface base {
    String doSomething();
}

class Main extends Func {
    @Override
    int add(int n, int m) {
        return n + m;
    }

    @Override
    public String doSomething() {
        return "do something";
    }
}

public class Act {
    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.add(1, 2) + m.doSomething());
    }
}
