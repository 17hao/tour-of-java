package xyz.shiqihao.designpattern.behavioral.template;

/**
 * 模板模式
 * <p>
 * 有一个抽象类将一套行为逻辑封装, 也就是将多个方法的调用封装在一个方法中, 这个方法就是一套模板,
 * 对外只暴露这个方法. 子类可以按自己的需要修改部逻辑, 但是不能修改整个执行流程.
 *
 * spring框架中的JdbcTemplate类使用了模板模式.
 */
public class Main {
    public static void main(String[] args) {
        FootballGame fg = new FootballGame();
        fg.play();

        BasketballGame bg = new BasketballGame();
        bg.play();
    }
}
