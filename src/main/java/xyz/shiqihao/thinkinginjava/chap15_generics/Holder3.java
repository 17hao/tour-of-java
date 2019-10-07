package xyz.shiqihao.thinkinginjava.chap15_generics;

public class Holder3<T> {
    private T a;

    private Holder3(T a) {
        this.a = a;
    }

    private T get() {
        return a;
    }

    void set(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Holder3<Automobile> h3 = new Holder3<>(new Automobile());
        Automobile a = h3.get();
        System.out.println(a);
    }
}
