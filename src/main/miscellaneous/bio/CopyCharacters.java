package main.miscellaneous.bio;

import java.io.*;

public class CopyCharacters {
    public static void main(String[] args) {
        try (
                Reader reader = new FileReader("F:\\javacode\\src\\etc\\io\\xanadu.txt");
                Writer writer = new FileWriter("characteroutput.txt")
        ) {
            int n;
            while ((n = reader.read()) != -1) {
                writer.write(n);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
