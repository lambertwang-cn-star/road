package com.banlv.road.support.network.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/9/1 11:21
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public class ChatServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof byte[]) {
            System.out.println("Get client byte message " + new String((byte[]) msg));
        } else {
            System.out.println("Get client other type message " + msg.toString());
        }
    }
}
