package xyz.shiqihao.advanced.zerocopy;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 传统方式实现的文件上传client.
 * 从FileInputStream中获取数据, 用Socket发送.
 */
public class TraditionalClient {
    public static void main(String[] args) {
        int port = 6688;
        String server = "localhost";
        Socket socket;
        FileInputStream inputStream;
        DataOutputStream outputStream;
        try {
            socket = new Socket(server, port);
            System.out.println("Connected with server " + socket.getInetAddress() +
                    ":" + socket.getPort());
            String fileName = "./src/main/resources/large.txt";
            inputStream = new FileInputStream(fileName);
            outputStream = new DataOutputStream(socket.getOutputStream());
            long start = System.currentTimeMillis();
            int total = 0, i;
            byte[] byteArr = new byte[4096];
            while ((i = inputStream.read(byteArr)) != -1) {
                total = total + i;
                outputStream.write(byteArr);
            }
            System.out.println("Client sends " + total + " bytes and spends " +
                    (System.currentTimeMillis() - start) + " mills");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
