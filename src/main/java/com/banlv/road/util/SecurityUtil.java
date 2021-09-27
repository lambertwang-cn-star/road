package com.banlv.road.util;

import com.banlv.road.support.security.BASE64Encoder;
import com.banlv.road.support.security.coder.*;
import org.apache.commons.codec.binary.Hex;

import java.util.Map;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/2/9 14:17
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public class SecurityUtil {
    private static final byte[] ENCRYPT_KEY = new byte[]{-81, 0, 105, 7, -32, 26, -49, 88};
    public static final String UTF8 = "UTF-8";

    private SecurityUtil() {
    }

    public static final byte[] decryptBASE64(String str) {
        try {
            return (new BASE64Encoder()).decode(str);
        } catch (Exception var2) {
            throw new RuntimeException("解密错误，错误信息：", var2);
        }
    }

    public static final String encryptBASE64(byte[] str) {
        try {
            return (new BASE64Encoder()).encode(str);
        } catch (Exception var2) {
            throw new RuntimeException("加密错误，错误信息：", var2);
        }
    }

    public static final String decryptDes(String cryptData) {
        return decryptDes(cryptData, ENCRYPT_KEY);
    }

    public static final String encryptDes(String data) {
        return encryptDes(data, ENCRYPT_KEY);
    }

    public static final String encryptMd5(String strSrc) {
        String outString = null;

        try {
            outString = encryptBASE64(MDCoder.encodeMD5(strSrc));
            return outString;
        } catch (Exception var3) {
            throw new RuntimeException("加密错误，错误信息：", var3);
        }
    }

    public static final String md5(String strSrc) {
        String outString = null;

        try {
            outString = Hex.encodeHexString(MDCoder.encodeMD5(strSrc));
            return outString;
        } catch (Exception var3) {
            throw new RuntimeException("加密错误，错误信息：", var3);
        }
    }

    public static final String encryptSHA(String data) {
        try {
            return encryptBASE64(SHACoder.encodeSHA256(data));
        } catch (Exception var2) {
            throw new RuntimeException("加密错误，错误信息：", var2);
        }
    }

    public static final String decryptDes(String cryptData, byte[] key) {
        String decryptedData = null;

        try {
            decryptedData = new String(DESCoder.decrypt(decryptBASE64(cryptData), key));
            return decryptedData;
        } catch (Exception var4) {
            throw new RuntimeException("解密错误，错误信息：", var4);
        }
    }

    public static final String encryptDes(String data, byte[] key) {
        String encryptedData = null;

        try {
            encryptedData = encryptBASE64(DESCoder.encrypt(data.getBytes(), key));
            return encryptedData;
        } catch (Exception var4) {
            throw new RuntimeException("加密错误，错误信息：", var4);
        }
    }

    public static final String signRSA(String data, String privateKey) {
        try {
            return encryptBASE64(RSACoder.sign(data.getBytes("UTF-8"), decryptBASE64(privateKey)));
        } catch (Exception var3) {
            throw new RuntimeException("签名错误，错误信息：", var3);
        }
    }

    public static final boolean verifyRSA(String data, String publicKey, String sign) {
        try {
            return RSACoder.verify(data.getBytes("UTF-8"), decryptBASE64(publicKey), decryptBASE64(sign));
        } catch (Exception var4) {
            throw new RuntimeException("验签错误，错误信息：", var4);
        }
    }

    public static final String encryptRSAPrivate(String data, String privateKey) {
        try {
            return encryptBASE64(RSACoder.encryptByPrivateKey(data.getBytes("UTF-8"), decryptBASE64(privateKey)));
        } catch (Exception var3) {
            throw new RuntimeException("解密错误，错误信息：", var3);
        }
    }

    public static final String decryptRSAPublic(String cryptData, String publicKey) {
        try {
            return new String(RSACoder.decryptByPublicKey(decryptBASE64(cryptData), decryptBASE64(publicKey)));
        } catch (Exception var3) {
            throw new RuntimeException("解密错误，错误信息：", var3);
        }
    }

    public static final String initHmacKey(String type) {
        try {
            return encryptBASE64(HmacCoder.initHmacKey(type));
        } catch (Exception var2) {
            throw new RuntimeException("获取HMAC密钥失败：", var2);
        }
    }

    public static final String encryptHMAC(String type, String data, String key) {
        try {
            return HmacCoder.encodeHmacHex(type, data.getBytes("UTF-8"), decryptBASE64(key));
        } catch (Exception var4) {
            throw new RuntimeException("加密错误，错误信息：", var4);
        }
    }

    public static String encryptPassword(String password) {
        return encryptMd5(encryptSHA(password));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(encryptDes("SHJR"));
        System.out.println(decryptDes("INzvw/3Qc4q="));
        System.out.println(encryptMd5("SHJR"));
        System.out.println(encryptSHA("1"));
        Map<String, Object> key = RSACoder.initKey();
        String privateKey = encryptBASE64(RSACoder.getPrivateKey(key));
        String publicKey = encryptBASE64(RSACoder.getPublicKey(key));
        System.out.println(privateKey);
        System.out.println(publicKey);
        String sign = signRSA("132", privateKey);
        System.out.println(sign);
        String encrypt = encryptRSAPrivate("132", privateKey);
        System.out.println(encrypt);
        String org = decryptRSAPublic(encrypt, publicKey);
        System.out.println(org);
        System.out.println(verifyRSA(org, publicKey, sign));
    }
}
