package xyz.shiqihao.thinking.in.java.chap14_typeinfo;

import java.util.Random;

/**
 * ①只有static final的常量才会被加入常量池,e.g.staticFinal1
 * ②通过.class获取Class对象也不会引起类的初始化.说明类加载的第一阶段`加载`最终产物是Class类的对象,
 * 第二阶段为静态变量分配内存空间并赋予默认值,第三阶初始化才会执行static代码块并赋予变量正确的值
 */
public class ClassInitialization {
    static Random random = new Random(47);

    public static void main(String[] args) {
        Class<?> clazz = Initialization1.class;
        System.out.println(Initialization1.staticFinal1);
        System.out.println(Initialization1.staticFinal2);
        System.out.println(Initialization2.staticNotFinal);
    }
}

class Initialization1 {
    static final int staticFinal1 = 47;
    static final int staticFinal2 = ClassInitialization.random.nextInt(74);

    static {
        System.out.println("Initializing Initialization1");
        System.out.println("===separator1===");
    }
}

class Initialization2 {
    static int staticNotFinal = 174;

    static {
        System.out.println("Initializing Initialization2");
        System.out.println("===separator2===");
    }
}