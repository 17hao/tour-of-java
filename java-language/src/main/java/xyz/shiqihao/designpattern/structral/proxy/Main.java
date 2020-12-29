package xyz.shiqihao.designpattern.structral.proxy;

/**
 * 创建一个抽象类或接口的实现类对象, 该对象委托(或者说使用)抽象类或接口的另一个实现类的方法.
 */
public class Main {
    public static void main(String[] args) {
        ImageService is = new ProxyImageService("download.jpg");
        is.display();
    }
}
