package xyz.shiqihao.advanced.netty.thirdexample;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class MyChatClient {
    public void run() {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(bossGroup).channel(NioSocketChannel.class);

            ChannelFuture f = b.connect("localhost", 6666).sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        MyChatClient client = new MyChatClient();
        client.run();
    }
}
