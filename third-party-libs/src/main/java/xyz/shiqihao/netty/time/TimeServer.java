package xyz.shiqihao.netty.time;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Sends the time to client as soon as possible.<br>
 * The time is the number of seconds since 00:00 (midnight) 1 January 1900 GMT.<br>
 * <a href = "https://tools.ietf.org/html/rfc868">https://tools.ietf.org/html/rfc868</a>
 */
public class TimeServer {
    private final int port;

    public TimeServer(int port) {
        this.port = port;
    }

    private void run() {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new TimeServerHandler());
            ChannelFuture f = b.bind(port).sync();
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        int port = 37;
        TimeServer server = new TimeServer(port);
        server.run();
    }
}
