package xyz.shiqihao.advanced.jvm.classload.initializing;

/**
 * javac xyz/shiqihao/advanced/jvm/classload/SimpleStatic.java
 * javap -verbose xyz.shiqihao.advanced.jvm.classload.initializing.SimpleStatic
 * <p>
 * 0: iconst_1
 * 1: putstatic     #2                  // Field id:I
 * 4: bipush        6
 * 6: putstatic     #3                  // Field number:I
 * 9: return
 * <p>
 * 类加载中初始化步骤重要的一步:执行编译器生成的<clinit>方法(如上)
 */
public class MyTest4 {
    static int id = 1;
    static int number;

    static {
        number = 6;
    }
}
