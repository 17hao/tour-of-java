package main.etc.reflection;

public class MyObj extends SuperClass implements MyInterface {
    private String str;

    public MyObj(String str, String str2) {
        this.str = str;
    }

    @Override
    public void method1() {

    }

    @Override
    public String method2(String... params) {
        StringBuilder result = new StringBuilder();
        for (String s : params) {
            result.append(s);
        }
        return result.toString();
    }

    class InnerClass {
    }
}

class SuperClass {
}

interface MyInterface {
    void method1();

    String method2(String... params);
}