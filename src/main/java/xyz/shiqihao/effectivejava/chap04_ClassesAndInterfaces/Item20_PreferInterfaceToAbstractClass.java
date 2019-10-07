package xyz.shiqihao.effectivejava.chap04_ClassesAndInterfaces;

public class Item20_PreferInterfaceToAbstractClass {
}

interface Singer {
    String sing();
}

interface Songwriter {
    String writeSong();
}

/**
 * More flexible
 */
class Musician implements Singer, Songwriter {
    @Override
    public String sing() {
        return "sing";
    }

    @Override
    public String writeSong() {
        return "song";
    }
}
