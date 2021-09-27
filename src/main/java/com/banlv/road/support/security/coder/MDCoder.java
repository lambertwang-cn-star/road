package com.banlv.road.support.security.coder;

import com.banlv.road.support.security.SecurityCoder;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/2/9 14:26
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public class MDCoder extends SecurityCoder {
    public MDCoder() {
    }

    public static byte[] encodeMD2(String data) throws Exception {
        return digest("MD2", data);
    }

    public static byte[] encodeMD4(String data) throws Exception {
        return digest("MD4", data);
    }

    public static byte[] encodeMD5(String data) throws Exception {
        return digest("MD5", data);
    }

    public static byte[] encodeTiger(String data) throws Exception {
        return digest("Tiger", data);
    }

    public static byte[] encodeWhirlpool(String data) throws Exception {
        return digest("Whirlpool", data);
    }

    public static byte[] encodeGOST3411(String data) throws Exception {
        return digest("GOST3411", data);
    }
}
