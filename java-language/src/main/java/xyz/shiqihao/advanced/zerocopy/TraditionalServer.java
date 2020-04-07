package xyz.shiqihao.advanced.zerocopy;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 传统方式实现的文件服务器. 接受客户端上传的文件.
 *
 * 在这里想记录一个知识点: ServerSocket和Socket的区别
 * 当我们实现一个基于tcp/ip协议的服务器时, 都会遇到这样的代码:
 * ServerSocket serverSocket = new ServerSocket(port)
 * Socket socket = serverSocket.accept();
 * InputStream is = socket.getInputStream();
 * 但是实现客户端时, 代码却变成了这样:
 * Socket socket = new Socket(server, port);
 * OutputStream os = socket.getOutputStream();
 *
 * 为什么服务端要有ServerSocket呢? 最终的原因来自于tcp连接的工作模式.
 * 当双方开始通信, 服务端要被动地等待侦听某个端口, 如果客户端发起连接,
 * 则服务端创建一个Socket(套接字)用于和客户端通信. 所以ServerSocket
 * 封装了被动等待侦听端口的行为, Socket则封装了和通信另一方交流的行为.
 * 在nio包中也有这样的区别存在: channel中有ServerSocketChannel和
 * SocketChannel.
 */
public class TraditionalServer {
    public static void main(String[] args) {
        int port = 6688;
        ServerSocket serverSocket;
        DataInputStream inputStream;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is waiting for connection on port: " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New connection accepted " + socket.getInetAddress() +
                        ":" + socket.getPort());
                inputStream = new DataInputStream(socket.getInputStream());
                byte[] byteArray = new byte[4096];
                int total = 0, i = 0;
                try {
                    while (i != -1) {
                       i = inputStream.read(byteArray);
                       total = total + i;
                    }
                    System.out.println("Server receives " + total + " bytes from client.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
