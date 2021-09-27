package com.banlv.road.support.network.nio;

import com.banlv.road.exception.RemoteSendRequestException;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/8/12 9:46
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public class RemoteHelper {
    public static void invokeSysn(final String addr, final long timeoutMills) {
        SocketAddress socketAddress = RemoteUtil.string2SocketAddress(addr);
        SocketChannel socketChannel = RemoteUtil.connect(socketAddress);
        long beginTime = System.currentTimeMillis();
        if(socketChannel != null) {
            boolean sendRequestOk = false;
            try{
                socketChannel.configureBlocking(true);
                socketChannel.socket().setSoTimeout((int) timeoutMills);
                ByteBuffer byteBuffer = ByteBuffer.allocate(4);
                byteBuffer.putInt(2);
                while(byteBuffer.hasRemaining()) {
                    int length = socketChannel.write(byteBuffer);
                    if(length >0 ) {
                        if(byteBuffer.hasRemaining()) {
                            if((System.currentTimeMillis() - beginTime) > timeoutMills) {
                                throw new RemoteSendRequestException(addr);
                            }
                        }
                    } else {
                        throw new RemoteSendRequestException(addr);
                    }
                }
                Thread.sleep(1);
                sendRequestOk = true;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try{
                    socketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
