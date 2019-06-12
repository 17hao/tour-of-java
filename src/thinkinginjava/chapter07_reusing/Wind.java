package thinkinginjava.chapter07_reusing;

/**
 * Inheritance & upcasting
 *
 * 继承不仅仅是为了"新的类提供方法"，更重要的是描述"子类是父类的一种类型"
 * 子类有父类所有的非private方法
 * 所以当向父类对象发送消息(方法调用)时，也可以向子类发送
 */
class Instrument {
    public void play() {
        System.out.println("play");
    }

    static void tune(Instrument i) {
        i.play();
    }
}

public class Wind extends Instrument {
    public static void main(String[] args) {
        Wind flute = new Wind();
        Instrument.tune(flute);
        flute.play();
    }
}
