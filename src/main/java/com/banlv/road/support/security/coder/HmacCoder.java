package com.banlv.road.support.security.coder;

import com.banlv.road.support.security.SecurityCoder;
import org.springframework.security.crypto.codec.Hex;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/2/9 14:20
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public abstract class HmacCoder extends SecurityCoder {
    public static final String MD2 = "HmacMD2";
    public static final String MD4 = "HmacMD4";
    public static final String MD5 = "HmacMD5";
    public static final String SHA1 = "HmacSHA1";
    public static final String SHA224 = "HmacSHA224";
    public static final String SHA256 = "HmacSHA256";
    public static final String SHA512 = "HmacSHA512";

    public HmacCoder() {
    }

    public static byte[] initHmacKey(String type) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(type);
        SecretKey secretKey = keyGenerator.generateKey();
        return secretKey.getEncoded();
    }

    public static byte[] encodeHmac(String type, byte[] data, byte[] key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(key, type);
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);
        return mac.doFinal(data);
    }

    public static String encodeHmacHex(String type, byte[] data, byte[] key) throws Exception {
        byte[] b = encodeHmac(type, data, key);
        return new String(Hex.encode(b));
    }
}
