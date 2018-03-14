package com.netty.learning.client;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by yaohaoqiang on 2018/3/14.
 */
public class EchoClientHandler extends ChannelHandlerAdapter {
    private int counter;

    static final String ECHO_REQ = "Hi, wahaha. Welcome to Netty.$_";

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        for (int i = 0; i < 100; i++) {
            ctx.writeAndFlush(Unpooled.copiedBuffer(ECHO_REQ.getBytes()));
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object o) throws Exception{
        System.out.println("This is " + ++counter + " time receive server : [" + o + "]");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable t) {
        t.printStackTrace();
        ctx.close();
    }
}
