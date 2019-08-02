package etc;

public interface Animal {
    default String eat() {
        return "eat";
    }

    String fly();
}

class Cats implements Animal{
    @Override
    public String fly() {
        return "i can't fly";
    }
}
