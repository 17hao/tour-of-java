package xyz.shiqihao.netty.time;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

public class TimeClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            ByteBuf m = (ByteBuf) msg;
            long currentTime = (m.readUnsignedInt() - 2208988800L) * 1000L;
            System.out.println(new Date(currentTime));
            ctx.close();
        } finally {
            ((ByteBuf) msg).release();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
