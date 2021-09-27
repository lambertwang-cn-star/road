package com.banlv.road.support.network.nio;

import static org.junit.jupiter.api.Assertions.*;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RemoteUtilTest {
    @Test
    public void getConnection() {
        SocketAddress sc = RemoteUtil.string2SocketAddress("127.0.0.1:80");
        Assert.assertEquals(null, RemoteUtil.connect(sc));
    }
}