package xyz.shiqihao.misc.netty.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest2 {
    public static void main(String[] args) throws Exception {
        FileOutputStream outputStream = new FileOutputStream("src/main/resources/output.txt");
        FileChannel channel = outputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(512);
        byte[] msg = "hello, world output".getBytes();
        for (byte b : msg) {
            buffer.put(b);
        }
        buffer.flip();
        channel.write(buffer);
        outputStream.close();
    }
}
