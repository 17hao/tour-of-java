package xyz.shiqihao.thinkinginjava.chapter10_innerclasses;

public class DotThis {
    private void f() {
        System.out.println("DotThis.f() ");
    }

    public class Inner {
        DotThis outer() {
            return DotThis.this; // .this生成对外部类对象的引用
        }
    }

    private Inner inner() {
        return new DotThis.Inner();
    }

    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis.Inner inner = dt.inner();
        inner.outer().f();
    }
}
