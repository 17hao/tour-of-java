package xyz.shiqihao.basic.bio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * 构建实验用的大体积文本
 */
public class MyTest5 {
    public static void main(String[] args) {
        try (FileOutputStream outputStream = new FileOutputStream("./src/main/resources/large.txt")) {
            byte[] bytes = new byte[4096];
            for (int i = 0; i < 20000; i++) {
                Arrays.fill(bytes, (byte) 0x0);
                outputStream.write(bytes);
            }
            System.out.println("finished");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
