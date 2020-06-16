package xyz.shiqihao.netty.echo.bio;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Single thread blocking I/O: block thread until last connection closed.
 */
public class SingleThreadEchoServer {
    private static final Logger logger = LogManager.getLogger();

    private void run() {
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(9000));
            logger.info("server is started." + serverSocket);
            while (!Thread.interrupted()) {
                Socket socket = serverSocket.accept();
                logger.info("client connected: " + socket);
                new SocketHandler(socket).handleRequest();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SingleThreadEchoServer server = new SingleThreadEchoServer();
        server.run();
    }

    private static class SocketHandler {
        private final Socket socket;

        public SocketHandler(Socket socket) {
            this.socket = socket;
        }

        public void handleRequest() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                    if (s.equals("exit")) {
                        logger.info("client disconnected " + socket);
                        socket.close();
                        break;
                    }
                    logger.info(socket.getRemoteSocketAddress() + " said: " + s);
                    writer.write(s);
                    writer.newLine();
                    writer.flush();
                }
            } catch (IOException e) {
                logger.error(e);
            }
        }
    }
}
