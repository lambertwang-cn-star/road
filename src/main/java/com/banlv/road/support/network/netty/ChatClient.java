package com.banlv.road.support.network.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/9/1 11:11
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public class ChatClient implements Runnable {

    private int port;

    public ChatClient(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new ChatClientHandler());
                        }
                    });
            ChannelFuture future = bootstrap.connect("127.0.0.1", port).sync();
            future.channel().writeAndFlush(Unpooled.copiedBuffer("777".getBytes()));
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workGroup.shutdownGracefully();
        }
    }

}
