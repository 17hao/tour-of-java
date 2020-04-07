package xyz.shiqihao.thinking.in.java.chap15_generics;

class Plane {
}

public class TupleTest {
    static TwoTuple<String, Integer> f() {
        return new TwoTuple<>("hi", 2);
    }

    static ThreeTuple<String, Integer, Plane> g() {
        return new ThreeTuple<>("hi", 2, new Plane());
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
        System.out.println(ttsi);

        ThreeTuple<String, Integer, Plane> ttsip = g();
        System.out.println(ttsip);
    }
}
