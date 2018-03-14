package com.netty.learning.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandlerInvoker;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yaohaoqiang on 2018/3/14.
 */
public class EchoServerHandler extends ChannelHandlerAdapter {
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object o) throws Exception {
        String body = (String) o;
        System.out.println("This is " + count.incrementAndGet() + " time receiveclient : [" + body + "]");
        body += "$_";
        ByteBuf echo = Unpooled.copiedBuffer(body.getBytes());
        ctx.writeAndFlush(echo);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable t) {
        t.printStackTrace();
        ctx.close();
    }
}
