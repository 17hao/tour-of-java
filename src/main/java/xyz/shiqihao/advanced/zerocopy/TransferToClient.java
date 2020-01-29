package xyz.shiqihao.advanced.zerocopy;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * 用zero-copy的方式实现的文件上传client. 上传一个80m大小的文件已经有了显著的性能提升.
 * <p>
 * 关键代码是使用了FileChannel的transferTo方法,
 * 查看该方法的javadoc其中写了'该方法潜在地比用简单循环方式从这个通道读取后写入另一个通道的做法更高效. 许多
 * 操作系统都支持将数据从文件系统缓存中直接拷贝到通道'. 具体的实现则是在sun包下. 零拷贝的内容写在有道云笔记.
 */
public class TransferToClient {
    public static void main(String[] args) {
        TransferToClient client = new TransferToClient();
        client.sendFile();
    }

    private void sendFile() {
        int port = 6688;
        String server = "localhost";
        try {
            SocketAddress address = new InetSocketAddress(server, port);
            SocketChannel sc = SocketChannel.open();
            sc.connect(address);
            sc.configureBlocking(true);

            String fileName = "./src/main/resources/large.txt";
            FileChannel fc = new FileInputStream(fileName).getChannel();
            long start = System.currentTimeMillis();
            long total = fc.transferTo(0, Long.MAX_VALUE, sc);
            System.out.println("Client send " + total + " bytes and spends " +
                    (System.currentTimeMillis() - start) + " millis.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
