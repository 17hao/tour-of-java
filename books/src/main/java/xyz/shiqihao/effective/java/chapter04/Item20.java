package xyz.shiqihao.effective.java.chapter04;

/**
 * 优先考虑使用接口而不是抽象类.
 * ① 接口可以绕开类只能单继承的缺点.
 * ② 从oop的角度看, 实现接口是获得了某种能力, 继承类是为了拓展某种能力. 实现接口
 * 可以视为一种可插拔的方式, 灵活性更胜一筹. 从java8开始接口可以有default方法, 进一步增强了接口.
 */
public class Item20 {
    public static void main(String[] args) {
        Musician m = new Musician();
        m.sing();
    }
}

interface Singer {
    default void sing() {
        System.out.println("I can singing a song.");
    }
}

interface Songwriter {
    String writeSong();
}

class Musician implements Singer, Songwriter {
    @Override
    public void sing() {
        System.out.println("I can singing another song.");
    }

    @Override
    public String writeSong() {
        return "song";
    }
}
