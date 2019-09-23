package xyz.shiqihao.thinkinginjava.chapter07_reusing;

class Art {
    Art() {
        System.out.println("Art constructor");
    }
}

class Drawing extends Art {
    Drawing() {
        System.out.println("Drawing constructor");
    }
}

/* 子类构造器初始化之前会自动调用父类的无参构造器 */
public class Cartoon extends Drawing {
    private Cartoon() {
        System.out.println("Cartoon constructor");
    }

    public static void main(String[] args) {
        new Cartoon();
    }
}
