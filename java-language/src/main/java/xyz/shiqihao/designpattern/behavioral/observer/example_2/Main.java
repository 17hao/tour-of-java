package xyz.shiqihao.designpattern.behavioral.observer.example_2;

/**
 * 观察者模式
 * 主题subject中有一个observer的列表以及一些状态
 * 当状态改变时, 通知这些observer
 * 通知的方式是调用这些observer中相应的方法
 */
public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new BinObserver(subject);
        new OctObserver(subject);
        new HexObserver(subject);

        System.out.println("State is: " + 8);
        subject.setState(8);
        System.out.println("State is: " + 6);
        subject.setState(6);
    }
}
