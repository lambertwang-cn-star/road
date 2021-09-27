package com.banlv.road.support.network.nio;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/8/12 9:42
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public class RemoteUtil {

    public static SocketAddress string2SocketAddress(final String addr) {
        int split = addr.lastIndexOf(":");
        String host = addr.substring(0, split);
        String port = addr.substring(split + 1);
        InetSocketAddress isa = new InetSocketAddress(host, Integer.parseInt(port));
        return isa;
    }

    public static SocketChannel connect(SocketAddress remote) {
        return connect(remote, 1000 * 5);
    }

    public static SocketChannel connect(SocketAddress remote, int timeoutMills) {
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(true);
            socketChannel.socket().setSoLinger(false, -1);
            socketChannel.socket().setTcpNoDelay(true);
            socketChannel.socket().setReceiveBufferSize(1024 * 64);
            socketChannel.socket().setSendBufferSize(1024 * 64);
            socketChannel.socket().connect(remote, timeoutMills);
            socketChannel.configureBlocking(false);
            return socketChannel;
        } catch (Exception e) {
            if (socketChannel != null) {
                try {
                    socketChannel.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
        return null;
    }
}
