package xyz.shiqihao.advanced.netty.secondexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDateTime;

public class MyClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) {
        System.out.println(ctx.channel().remoteAddress());
        System.out.println("client output " + msg);
        ctx.channel().writeAndFlush("from client " + LocalDateTime.now());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.writeAndFlush("Greeting from client");
    }
}
