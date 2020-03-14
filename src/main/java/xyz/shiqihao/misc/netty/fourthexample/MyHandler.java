package xyz.shiqihao.misc.netty.fourthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

public class MyHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            String eventType = null;
            switch (event.state()) {
                case READER_IDLE:
                    eventType = "read free";
                    break;
                case WRITER_IDLE:
                    eventType = "write free";
                    break;
                case ALL_IDLE:
                    eventType = "all free";
                    break;
            }
            System.out.println(ctx.channel().remoteAddress() + " 超时事件 " + eventType);
            ctx.channel().close();
        }
    }
}
