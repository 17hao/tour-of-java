package main.designpattern.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputTest {
    public static void main(String[] args) {
        int c;
        String path = "/Users/17hao/IdeaProjects/javacode/src/main/designpattern/decorator/test.txt";
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
