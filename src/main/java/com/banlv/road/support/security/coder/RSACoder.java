package com.banlv.road.support.security.coder;

import com.banlv.road.support.security.SecurityCoder;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/2/9 14:24
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public class RSACoder extends SecurityCoder {
    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "SHA1withRSA";
    private static final String PUBLIC_KEY = "RSAPublicKey";
    private static final String PRIVATE_KEY = "RSAPrivateKey";
    private static final int KEY_SIZE = 2048;

    public RSACoder() {
    }

    public static byte[] sign(byte[] data, byte[] privateKey) throws Exception {
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(privateKey);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);
        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initSign(priKey);
        signature.update(data);
        return signature.sign();
    }

    public static boolean verify(byte[] data, byte[] publicKey, byte[] sign) throws Exception {
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKey);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey pubKey = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initVerify(pubKey);
        signature.update(data);
        return signature.verify(sign);
    }

    public static byte[] decryptByPrivateKey(byte[] data, byte[] key) throws Exception {
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(2, privateKey);
        return cipher.doFinal(data);
    }

    public static byte[] decryptByPublicKey(byte[] data, byte[] key) throws Exception {
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(2, publicKey);
        return cipher.doFinal(data);
    }

    public static byte[] encryptByPublicKey(byte[] data, byte[] key) throws Exception {
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(1, publicKey);
        return cipher.doFinal(data);
    }

    public static byte[] encryptByPrivateKey(byte[] data, byte[] key) throws Exception {
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(1, privateKey);
        return cipher.doFinal(data);
    }

    public static byte[] getPrivateKey(Map<String, Object> keyMap) throws Exception {
        Key key = (Key)keyMap.get("RSAPrivateKey");
        return key.getEncoded();
    }

    public static byte[] getPublicKey(Map<String, Object> keyMap) throws Exception {
        Key key = (Key)keyMap.get("RSAPublicKey");
        return key.getEncoded();
    }

    public static Map<String, Object> initKey() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey)keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey)keyPair.getPrivate();
        Map<String, Object> keyMap = new HashMap(2);
        keyMap.put("RSAPublicKey", publicKey);
        keyMap.put("RSAPrivateKey", privateKey);
        return keyMap;
    }
}
