package effectivejava.chapter06_EnumsAndAnnotations;

public class Item40_ConsistentlyUseOverrideAnnotation {
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
