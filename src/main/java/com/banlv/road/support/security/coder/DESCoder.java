package com.banlv.road.support.security.coder;

import com.banlv.road.support.security.SecurityCoder;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/2/9 14:20
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public abstract class DESCoder extends SecurityCoder {
    public static final String KEY_ALGORITHM = "DES";
    public static final String CIPHER_ALGORITHM = "DES/ECB/PKCS5PADDING";

    public DESCoder() {
    }

    private static Key toKey(byte[] key) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException {
        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(dks);
        return secretKey;
    }

    public static byte[] decrypt(byte[] data, byte[] key) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        Key k = toKey(key);
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5PADDING");
        cipher.init(2, k);
        return cipher.doFinal(data);
    }

    public static byte[] encrypt(byte[] data, byte[] key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {
        Key k = toKey(key);
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5PADDING");
        cipher.init(1, k);
        return cipher.doFinal(data);
    }

    public static byte[] initKey() throws NoSuchAlgorithmException {
        KeyGenerator kg = KeyGenerator.getInstance("DES");
        kg.init(56, new SecureRandom());
        SecretKey secretKey = kg.generateKey();
        return secretKey.getEncoded();
    }
}
