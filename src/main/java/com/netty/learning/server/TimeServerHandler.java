package com.netty.learning.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yaohaoqiang on 2018/3/13.
 */
public class TimeServerHandler extends ChannelHandlerAdapter {

    private static int count = 0;

    private static AtomicInteger safeCount = new AtomicInteger(0);

    @Override
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        String body = (String) o;
//        byte[] req = new byte[buf.readableBytes()];
//        buf.readBytes(req);
//        String body = new String(req, "utf-8");
        System.out.println("Local Thead : " + Thread.currentThread().getName() + " Remote Thread : " + body + " " + ++count + " " + safeCount.incrementAndGet());

        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
        ByteBuf resp = Unpooled.copiedBuffer((currentTime + System.getProperty("line.separator")).getBytes());
        channelHandlerContext.write(resp);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }
}
