package com.gaffy.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("EchoServerHandler");
        ByteBuf in = (ByteBuf) msg;
        try {
            ByteBuf byteBuf = in.readerIndex(0);
            ctx.writeAndFlush(byteBuf);
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
}
