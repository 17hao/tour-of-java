package xyz.shiqihao.netty.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest1 {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("src/main/resources/input.txt");
        FileChannel channel = inputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(512);
        channel.read(buffer);
        buffer.flip();
        while (buffer.remaining() > 0) {
            System.out.print((char) buffer.get());
        }
        inputStream.close();
    }
}
