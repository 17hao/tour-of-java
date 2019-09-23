package xyz.shiqihao.thinkinginjava.chapter07_reusing;

class Game {
    Game(int i) {
        System.out.println(i + "Game constructor");
    }
}

/* 当父类的构造器有参数，子类要显示地在构造器中调用父类构造器( super() ) */
class BoardGame extends Game {
    BoardGame(int i) {
        super(i);
        System.out.println("BoardGame constructor");
    }
}

public class Chess extends BoardGame {
    private Chess(int i) {
        super(i);
        System.out.println("Chess constructor");
    }

    public static void main(String[] args) {
        new Chess(100);
    }
}
