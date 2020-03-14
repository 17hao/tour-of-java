package xyz.shiqihao.misc.netty.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * FileChannel is an alternative to Java IO api
 * FileChannel + ByteBuffer
 */
public class MyTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("./src/main/proto/helloworld.proto", "rw");
        FileChannel ch = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(48);
        int byteRead = ch.read(buffer);
        int count = 1;
        while (byteRead != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }
            buffer.clear();
            byteRead = ch.read(buffer);
            count++;
        }
        file.close();
        System.out.println("\nread " + count + " times");
    }
}
