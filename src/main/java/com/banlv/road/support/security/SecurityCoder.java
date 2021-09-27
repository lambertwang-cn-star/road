package com.banlv.road.support.security;

import java.security.MessageDigest;
import java.security.Security;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/2/9 14:21
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public abstract class SecurityCoder {
    private static Byte ADDFLAG = 0;

    public SecurityCoder() {
    }

    public static byte[] digest(String algorithm, String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        return md.digest(data.getBytes("UTF-8"));
    }

    static {
        if (ADDFLAG == 0) {
            Security.addProvider(new BouncyCastleProvider());
            ADDFLAG = 1;
        }

    }
}
