package xyz.shiqihao.effective.java.chapter06;

/**
 * 坚持使用@Override注解. 如果不使用这个注解, 当重写父类方法时使用了错误的参数类型, 编译器将无法检查出.
 */
public class Item40 {
}

class Bigram {
    private final char first;
    private final char second;

    Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Bigram))
            return false;
        Bigram b = (Bigram) obj;
        return b.first == first && b.second == second;
    }
}
