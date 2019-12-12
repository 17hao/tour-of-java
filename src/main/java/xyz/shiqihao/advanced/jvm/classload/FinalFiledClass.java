package xyz.shiqihao.advanced.jvm.classload;

/**
 * output: CONST
 *
 * javap -verbose xyz.shiqihao.advanced.jvm.classload.UseFinalFiledClass
 *
 * public static void main(java.lang.String[]);
 *     descriptor: ([Ljava/lang/String;)V
 *     flags: ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=2, locals=1, args_size=1
 *          0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *          3: ldc           #4                  // String CONST
 *          5: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *          8: return
 *
 * FinalFiledClass并没有被使用, 常亮`CONST`被直接放入常量池.
 */
class FinalFiledClass {
    final static String CONSTANT = "CONST";

    static {
        System.out.println("FinalFiledClass init");
    }
}

class UseFinalFiledClass {
    public static void main(String[] args) {
        System.out.println(FinalFiledClass.CONSTANT);
    }
}