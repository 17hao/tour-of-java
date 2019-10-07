package xyz.shiqihao.thinkinginjava.chap12_exceptions;

class SimpleException extends Exception {
}

public class InheritingException {
    private void f() throws SimpleException {
        System.out.println("Throw exception from f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        InheritingException sed = new InheritingException();
        try {
            sed.f();
        } catch (SimpleException e) {
            System.out.println("catch it!");
        }
    }
}
