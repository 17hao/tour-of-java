package chapter14_typeinfo;

public class SweetShop {
    public static void main(String[] args) {
        System.out.println("inside main");
        new Candy();
        try {
            /*
              每个类或接口会创建一个Class对象，保存在.class文件中
              调用类的static成员会使Class对象被加载
              .class文件被加载时会加载static成员
              类只有被需要用到时，类加载器才会将.class文件加载到内存
              一旦类的.class文件被加载，它就被用来创建类的对象
              */
            Class.forName("chapter14_typeinfo.Gum"); // fully qualified name
        } catch (ClassNotFoundException e) {
            System.out.println("couldn't find Gum");
        }
        System.out.println("after Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("after loading cookie");
    }
}

class Candy {
    static {
        System.out.println("loading candy");
    }
}

class Gum {
    static {
        System.out.println("loading gum");
    }
}

class Cookie {
    static {
        System.out.println("loading cookie");
    }
}


