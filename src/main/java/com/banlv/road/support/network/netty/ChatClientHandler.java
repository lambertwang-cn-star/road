package com.banlv.road.support.network.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/9/1 11:21
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public class ChatClientHandler extends ChannelOutboundHandlerAdapter {

    private static final String SUCCESS = "success to conneted";

    @Override
    public void read(ChannelHandlerContext ctx) throws Exception {
        ChannelHandlerContext context = ctx.read();
        System.out.println("Success to connect the server!");
        context.writeAndFlush(SUCCESS, ctx.voidPromise());
        System.out.println("Success to send msg to the server!");
    }
}
