package com.netty.learning.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.logging.Logger;

/**
 * Created by yaohaoqiang on 2018/3/13.
 */
public class TimeClientHandler extends ChannelHandlerAdapter {
    private static final Logger logger = Logger.getLogger(TimeClientHandler.class.getName());

    private byte[] req;

    public TimeClientHandler() {
        req = (Thread.currentThread().getName() + System.getProperty("line.separator")).getBytes();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
//        ctx.writeAndFlush(firstMessage);
        ByteBuf message = null;
        for (int i = 0; i < 10000; i++) {
            message = Unpooled.buffer(req.length);
            message.writeBytes(req);
            ctx.writeAndFlush(message);
        }

    }


    @Override
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        String buf = (String) o;
//        byte[] req = new byte[buf.readableBytes()];
//        buf.readBytes(req);
//        String body = new String(req, "utf-8");
        System.out.println("Now is : " + buf);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        logger.warning("Unexpected exception from downstream : " + cause.getMessage());
        ctx.close();
    }
}
