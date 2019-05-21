package chapter02_operators;

class Letter {
    char c;
}

public class PassObject {
    private static void f(Letter l) {
        l.c = 'x';
    }

    public static void main(String[] args) {
        Letter l = new Letter();
        l.c = 'a';
        System.out.println("1: l.c = " + l.c);
        f(l);
        System.out.println("2: l.c = " + l.c);
    }
}
