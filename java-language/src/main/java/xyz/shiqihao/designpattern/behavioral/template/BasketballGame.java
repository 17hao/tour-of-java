package xyz.shiqihao.designpattern.behavioral.template;

public class BasketballGame extends Game {
    @Override
    protected void initialize() {
        System.out.println("Basketball game initialized.");
    }

    @Override
    protected void startPlay() {
        System.out.println("Basketball game started.");
    }

    @Override
    protected void endPlay() {
        System.out.println("Basketball game ended.");
    }
}
