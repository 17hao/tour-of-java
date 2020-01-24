package xyz.shiqihao.designpattern.structral.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 装饰器模式的关键在于装饰两个字, 它的含义是给原有的东西添砖加瓦. 装饰器模式用组合的方式将待装饰对象作为
 * 新对象的属性, 用构造方法依赖注入的方式创建新的对象, 并给待装饰对象添加新的功能.
 */
public class InputTest {
    public static void main(String[] args) {
        int c;
        String path = "/Users/17hao/IdeaProjects/javacode/src/main/xyz.shiqihao.designpattern/decorator/test.txt";
        try (InputStream inputStream =
                     new LowerCaseInputStream(
                             new BufferedInputStream(
                                     new FileInputStream(path)))) {

            while ((c = inputStream.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
