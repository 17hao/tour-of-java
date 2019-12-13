package xyz.shiqihao.advanced.jvm.classload;

/**
 * output: 2
 * 子类<clinit>方法优先级高于父类
 */
public class ChildSimpleStatic extends SimpleStatic {
    static {
        number = 2;
    }

    public static void main(String[] args) {
        System.out.println(number);
    }
}
