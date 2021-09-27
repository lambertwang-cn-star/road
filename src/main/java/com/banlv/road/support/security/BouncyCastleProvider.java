package com.banlv.road.support.security;

import java.security.Provider;

/**
 * @author ：Lambert Wang
 * @date ：Created in 2021/2/9 14:22
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
public class BouncyCastleProvider extends Provider {
    private static final String info = "BouncyCastle Security Provider v1.23";
    public static final String PROVIDER_NAME = "BC";

    public BouncyCastleProvider() {
        super("BC", 1.23D, "BouncyCastle Security Provider v1.23");
        this.put("KeyStore.BKS", "org.bouncycastle.jce.provider.JDKKeyStore");
        this.put("KeyStore.BouncyCastle", "org.bouncycastle.jce.provider.JDKKeyStore$BouncyCastleStore");
        this.put("KeyStore.PKCS12", "org.bouncycastle.jce.provider.JDKPKCS12KeyStore$BCPKCS12KeyStore");
        this.put("KeyStore.BCPKCS12", "org.bouncycastle.jce.provider.JDKPKCS12KeyStore$BCPKCS12KeyStore");
        this.put("KeyStore.PKCS12-DEF", "org.bouncycastle.jce.provider.JDKPKCS12KeyStore$DefPKCS12KeyStore");
        this.put("Alg.Alias.KeyStore.UBER", "BouncyCastle");
        this.put("Alg.Alias.KeyStore.BOUNCYCASTLE", "BouncyCastle");
        this.put("Alg.Alias.KeyStore.bouncycastle", "BouncyCastle");
        this.put("CertificateFactory.X.509", "org.bouncycastle.jce.provider.JDKX509CertificateFactory");
        this.put("Alg.Alias.CertificateFactory.X509", "X.509");
        this.put("AlgorithmParameterGenerator.DH", "org.bouncycastle.jce.provider.JDKAlgorithmParameterGenerator$DH");
        this.put("AlgorithmParameterGenerator.DSA", "org.bouncycastle.jce.provider.JDKAlgorithmParameterGenerator$DSA");
        this.put("AlgorithmParameterGenerator.ELGAMAL", "org.bouncycastle.jce.provider.JDKAlgorithmParameterGenerator$ElGamal");
        this.put("AlgorithmParameterGenerator.DES", "org.bouncycastle.jce.provider.JDKAlgorithmParameterGenerator$DES");
        this.put("AlgorithmParameterGenerator.DESEDE", "org.bouncycastle.jce.provider.JDKAlgorithmParameterGenerator$DES");
        this.put("AlgorithmParameterGenerator.1.2.840.113549.3.7", "org.bouncycastle.jce.provider.JDKAlgorithmParameterGenerator$DES");
        this.put("AlgorithmParameterGenerator.1.3.14.3.2.7", "org.bouncycastle.jce.provider.JDKAlgorithmParameterGenerator$DES");
        this.put("AlgorithmParameterGenerator.IDEA", "org.bouncycastle.jce.provider.JDKAlgorithmParameterGenerator$IDEA");
        this.put("AlgorithmParameterGenerator.1.3.6.1.4.1.188.7.1.1.2", "org.bouncycastle.jce.provider.JDKAlgorithmParameterGenerator$IDEA");
        this.put("AlgorithmParameterGenerator.RC2", "org.bouncycastle.jce.provider.JDKAlgorithmParameterGenerator$RC2");
        this.put("AlgorithmParameterGenerator.1.2.840.113549.3.2", "org.bouncycastle.jce.provider.JDKAlgorithmParameterGenerator$RC2");
        this.put("AlgorithmParameterGenerator.CAST5", "org.bouncycastle.jce.provider.JDKAlgorithmParameterGenerator$CAST5");
        this.put("AlgorithmParameterGenerator.1.2.840.113533.7.66.10", "org.bouncycastle.jce.provider.JDKAlgorithmParameterGenerator$CAST5");
        this.put("AlgorithmParameterGenerator.AES", "org.bouncycastle.jce.provider.JDKAlgorithmParameterGenerator$AES");
        this.put("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.2", "AES");
        this.put("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.22", "AES");
        this.put("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.42", "AES");
        this.put("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.1.2", "AES");
        this.put("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.1.22", "AES");
        this.put("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.1.42", "AES");
        this.put("AlgorithmParameters.DH", "org.bouncycastle.jce.provider.JDKAlgorithmParameters$DH");
        this.put("AlgorithmParameters.DSA", "org.bouncycastle.jce.provider.JDKAlgorithmParameters$DSA");
        this.put("AlgorithmParameters.ELGAMAL", "org.bouncycastle.jce.provider.JDKAlgorithmParameters$ElGamal");
        this.put("AlgorithmParameters.IES", "org.bouncycastle.jce.provider.JDKAlgorithmParameters$IES");
        this.put("AlgorithmParameters.PKCS12PBE", "org.bouncycastle.jce.provider.JDKAlgorithmParameters$PKCS12PBE");
        this.put("AlgorithmParameters.1.2.840.113549.3.7", "org.bouncycastle.jce.provider.JDKAlgorithmParameters$IVAlgorithmParameters");
        this.put("AlgorithmParameters.IDEA", "org.bouncycastle.jce.provider.JDKAlgorithmParameters$IDEAAlgorithmParameters");
        this.put("AlgorithmParameters.1.3.6.1.4.1.188.7.1.1.2", "org.bouncycastle.jce.provider.JDKAlgorithmParameters$IDEAAlgorithmParameters");
        this.put("AlgorithmParameters.CAST5", "org.bouncycastle.jce.provider.JDKAlgorithmParameters$CAST5AlgorithmParameters");
        this.put("AlgorithmParameters.1.2.840.113533.7.66.10", "org.bouncycastle.jce.provider.JDKAlgorithmParameters$CAST5AlgorithmParameters");
        this.put("Alg.Alias.AlgorithmParameters.PBEWITHSHA1ANDRC2", "PKCS12PBE");
        this.put("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND3-KEYTRIPLEDES", "PKCS12PBE");
        this.put("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND2-KEYTRIPLEDES", "PKCS12PBE");
        this.put("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDRC2", "PKCS12PBE");
        this.put("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDRC4", "PKCS12PBE");
        this.put("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDTWOFISH", "PKCS12PBE");
        this.put("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDIDEA", "PKCS12PBE");
        this.put("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.1", "PKCS12PBE");
        this.put("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.2", "PKCS12PBE");
        this.put("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.3", "PKCS12PBE");
        this.put("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.4", "PKCS12PBE");
        this.put("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.5", "PKCS12PBE");
        this.put("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.6", "PKCS12PBE");
        this.put("KeyAgreement.DH", "org.bouncycastle.jce.provider.JCEDHKeyAgreement");
        this.put("KeyAgreement.ECDH", "org.bouncycastle.jce.provider.JCEECDHKeyAgreement$DH");
        this.put("KeyAgreement.ECDHC", "org.bouncycastle.jce.provider.JCEECDHKeyAgreement$DHC");
        this.put("Cipher.DES", "org.bouncycastle.jce.provider.JCEBlockCipher$DES");
        this.put("Cipher.DESEDE", "org.bouncycastle.jce.provider.JCEBlockCipher$DESede");
        this.put("Cipher.1.2.840.113549.3.7", "org.bouncycastle.jce.provider.JCEBlockCipher$DESedeCBC");
        this.put("Cipher.1.3.14.3.2.7", "org.bouncycastle.jce.provider.JCEBlockCipher$DESCBC");
        this.put("Cipher.DESEDEWRAP", "org.bouncycastle.jce.provider.WrapCipherSpi$DESEDEWrap");
        this.put("Cipher.1.2.840.113549.1.9.16.3.6", "org.bouncycastle.jce.provider.WrapCipherSpi$DESEDEWrap");
        this.put("Cipher.SKIPJACK", "org.bouncycastle.jce.provider.JCEBlockCipher$Skipjack");
        this.put("Cipher.BLOWFISH", "org.bouncycastle.jce.provider.JCEBlockCipher$Blowfish");
        this.put("Cipher.TWOFISH", "org.bouncycastle.jce.provider.JCEBlockCipher$Twofish");
        this.put("Cipher.RC2", "org.bouncycastle.jce.provider.JCEBlockCipher$RC2");
        this.put("Cipher.RC2WRAP", "org.bouncycastle.jce.provider.WrapCipherSpi$RC2Wrap");
        this.put("Cipher.1.2.840.113549.1.9.16.3.7", "org.bouncycastle.jce.provider.WrapCipherSpi$RC2Wrap");
        this.put("Cipher.ARC4", "org.bouncycastle.jce.provider.JCEStreamCipher$RC4");
        this.put("Cipher.RC4", "org.bouncycastle.jce.provider.JCEStreamCipher$RC4");
        this.put("Alg.Alias.Cipher.1.2.840.113549.3.4", "RC4");
        this.put("Cipher.RC5", "org.bouncycastle.jce.provider.JCEBlockCipher$RC5");
        this.put("Cipher.1.2.840.113549.3.2", "org.bouncycastle.jce.provider.JCEBlockCipher$RC2CBC");
        this.put("Alg.Alias.Cipher.RC5-32", "RC5");
        this.put("Cipher.RC5-64", "org.bouncycastle.jce.provider.JCEBlockCipher$RC564");
        this.put("Cipher.RC6", "org.bouncycastle.jce.provider.JCEBlockCipher$RC6");
        this.put("Cipher.RIJNDAEL", "org.bouncycastle.jce.provider.JCEBlockCipher$Rijndael");
        this.put("Cipher.AES", "org.bouncycastle.jce.provider.JCEBlockCipher$AES");
        this.put("Alg.Alias.Cipher.2.16.840.1.101.3.4.2", "AES");
        this.put("Alg.Alias.Cipher.2.16.840.1.101.3.4.22", "AES");
        this.put("Alg.Alias.Cipher.2.16.840.1.101.3.4.42", "AES");
        this.put("Cipher.2.16.840.1.101.3.4.1.2", "org.bouncycastle.jce.provider.JCEBlockCipher$AESCBC");
        this.put("Cipher.2.16.840.1.101.3.4.1.22", "org.bouncycastle.jce.provider.JCEBlockCipher$AESCBC");
        this.put("Cipher.2.16.840.1.101.3.4.1.42", "org.bouncycastle.jce.provider.JCEBlockCipher$AESCBC");
        this.put("Cipher.AESWRAP", "org.bouncycastle.jce.provider.WrapCipherSpi$AESWrap");
        this.put("Cipher.SERPENT", "org.bouncycastle.jce.provider.JCEBlockCipher$Serpent");
        this.put("Cipher.CAST5", "org.bouncycastle.jce.provider.JCEBlockCipher$CAST5");
        this.put("Cipher.1.2.840.113533.7.66.10", "org.bouncycastle.jce.provider.JCEBlockCipher$CAST5CBC");
        this.put("Cipher.CAST6", "org.bouncycastle.jce.provider.JCEBlockCipher$CAST6");
        this.put("Cipher.IDEA", "org.bouncycastle.jce.provider.JCEBlockCipher$IDEA");
        this.put("Cipher.1.3.6.1.4.1.188.7.1.1.2", "org.bouncycastle.jce.provider.JCEBlockCipher$IDEACBC");
        this.put("Cipher.RSA", "org.bouncycastle.jce.provider.JCERSACipher$NoPadding");
        this.put("Cipher.RSA/RAW", "org.bouncycastle.jce.provider.JCERSACipher$NoPadding");
        this.put("Cipher.RSA/PKCS1", "org.bouncycastle.jce.provider.JCERSACipher$PKCS1v1_5Padding");
        this.put("Cipher.1.2.840.113549.1.1.1", "org.bouncycastle.jce.provider.JCERSACipher$PKCS1v1_5Padding");
        this.put("Cipher.2.5.8.1.1", "org.bouncycastle.jce.provider.JCERSACipher$PKCS1v1_5Padding");
        this.put("Cipher.RSA/1", "org.bouncycastle.jce.provider.JCERSACipher$PKCS1v1_5Padding_PrivateOnly");
        this.put("Cipher.RSA/2", "org.bouncycastle.jce.provider.JCERSACipher$PKCS1v1_5Padding_PublicOnly");
        this.put("Cipher.RSA/OAEP", "org.bouncycastle.jce.provider.JCERSACipher$OAEPPadding");
        this.put("Cipher.1.2.840.113549.1.1.7", "org.bouncycastle.jce.provider.JCERSACipher$OAEPPadding");
        this.put("Cipher.RSA/ISO9796-1", "org.bouncycastle.jce.provider.JCERSACipher$ISO9796d1Padding");
        this.put("Cipher.ECIES", "org.bouncycastle.jce.provider.JCEIESCipher$ECIES");
        this.put("Cipher.ELGAMAL", "org.bouncycastle.jce.provider.JCEElGamalCipher$NoPadding");
        this.put("Cipher.ELGAMAL/PKCS1", "org.bouncycastle.jce.provider.JCEElGamalCipher$PKCS1v1_5Padding");
        this.put("Alg.Alias.Cipher.RSA//RAW", "RSA");
        this.put("Alg.Alias.Cipher.RSA//NOPADDING", "RSA");
        this.put("Alg.Alias.Cipher.RSA//PKCS1PADDING", "RSA/PKCS1");
        this.put("Alg.Alias.Cipher.RSA//OAEPPADDING", "RSA/OAEP");
        this.put("Alg.Alias.Cipher.RSA//ISO9796-1PADDING", "RSA/ISO9796-1");
        this.put("Alg.Alias.Cipher.RSA/ECB/NOPADDING", "RSA");
        this.put("Alg.Alias.Cipher.RSA/ECB/PKCS1PADDING", "RSA/PKCS1");
        this.put("Alg.Alias.Cipher.RSA/ECB/OAEPPADDING", "RSA/OAEP");
        this.put("Alg.Alias.Cipher.RSA/ECB/ISO9796-1PADDING", "RSA/ISO9796-1");
        this.put("Alg.Alias.Cipher.RSA/NONE/NOPADDING", "RSA");
        this.put("Alg.Alias.Cipher.RSA/NONE/PKCS1PADDING", "RSA/PKCS1");
        this.put("Alg.Alias.Cipher.RSA/NONE/OAEPPADDING", "RSA/OAEP");
        this.put("Alg.Alias.Cipher.RSA/NONE/ISO9796-1PADDING", "RSA/ISO9796-1");
        this.put("Alg.Alias.Cipher.RSA/1/PCKS1PADDING", "RSA/1");
        this.put("Alg.Alias.Cipher.RSA/2/PCKS1PADDING", "RSA/2");
        this.put("Alg.Alias.Cipher.ELGAMAL/ECB/PKCS1PADDING", "ELGAMAL/PKCS1");
        this.put("Alg.Alias.Cipher.ELGAMAL/NONE/PKCS1PADDING", "ELGAMAL/PKCS1");
        this.put("Cipher.PBEWITHMD5ANDDES", "org.bouncycastle.jce.provider.JCEBlockCipher$PBEWithMD5AndDES");
        this.put("Cipher.BROKENPBEWITHMD5ANDDES", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithMD5AndDES");
        this.put("Cipher.PBEWITHMD5ANDRC2", "org.bouncycastle.jce.provider.JCEBlockCipher$PBEWithMD5AndRC2");
        this.put("Cipher.PBEWITHSHA1ANDDES", "org.bouncycastle.jce.provider.JCEBlockCipher$PBEWithSHA1AndDES");
        this.put("Cipher.BROKENPBEWITHSHA1ANDDES", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithSHA1AndDES");
        this.put("Cipher.PBEWITHSHA1ANDRC2", "org.bouncycastle.jce.provider.JCEBlockCipher$PBEWithSHA1AndRC2");
        this.put("Cipher.PBEWITHSHAAND3-KEYTRIPLEDES-CBC", "org.bouncycastle.jce.provider.JCEBlockCipher$PBEWithSHAAndDES3Key");
        this.put("Cipher.BROKENPBEWITHSHAAND3-KEYTRIPLEDES-CBC", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithSHAAndDES3Key");
        this.put("Cipher.OLDPBEWITHSHAAND3-KEYTRIPLEDES-CBC", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$OldPBEWithSHAAndDES3Key");
        this.put("Cipher.PBEWITHSHAAND2-KEYTRIPLEDES-CBC", "org.bouncycastle.jce.provider.JCEBlockCipher$PBEWithSHAAndDES2Key");
        this.put("Cipher.BROKENPBEWITHSHAAND2-KEYTRIPLEDES-CBC", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithSHAAndDES2Key");
        this.put("Cipher.PBEWITHSHAAND128BITRC2-CBC", "org.bouncycastle.jce.provider.JCEBlockCipher$PBEWithSHAAnd128BitRC2");
        this.put("Cipher.PBEWITHSHAAND40BITRC2-CBC", "org.bouncycastle.jce.provider.JCEBlockCipher$PBEWithSHAAnd40BitRC2");
        this.put("Cipher.PBEWITHSHAAND128BITRC4", "org.bouncycastle.jce.provider.JCEStreamCipher$PBEWithSHAAnd128BitRC4");
        this.put("Cipher.PBEWITHSHAAND40BITRC4", "org.bouncycastle.jce.provider.JCEStreamCipher$PBEWithSHAAnd40BitRC4");
        this.put("Cipher.PBEWITHSHAANDTWOFISH-CBC", "org.bouncycastle.jce.provider.JCEBlockCipher$PBEWithSHAAndTwofish");
        this.put("Cipher.OLDPBEWITHSHAANDTWOFISH-CBC", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$OldPBEWithSHAAndTwofish");
        this.put("Cipher.PBEWITHSHAANDIDEA-CBC", "org.bouncycastle.jce.provider.JCEBlockCipher$PBEWithSHAAndIDEA");
        this.put("Alg.Alias.Cipher.1.2.840.113549.1.12.1.1", "PBEWITHSHAAND128BITRC4");
        this.put("Alg.Alias.Cipher.1.2.840.113549.1.12.1.2", "PBEWITHSHAAND40BITRC4");
        this.put("Alg.Alias.Cipher.1.2.840.113549.1.12.1.3", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
        this.put("Alg.Alias.Cipher.1.2.840.113549.1.12.1.4", "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
        this.put("Alg.Alias.Cipher.1.2.840.113549.1.12.1.5", "PBEWITHSHAAND128BITRC2-CBC");
        this.put("Alg.Alias.Cipher.1.2.840.113549.1.12.1.6", "PBEWITHSHAAND40BITRC2-CBC");
        this.put("KeyGenerator.DES", "org.bouncycastle.jce.provider.JCEKeyGenerator$DES");
        this.put("Alg.Alias.KeyGenerator.1.3.14.3.2.7", "DES");
        this.put("KeyGenerator.DESEDE", "org.bouncycastle.jce.provider.JCEKeyGenerator$DESede");
        this.put("KeyGenerator.1.2.840.113549.3.7", "org.bouncycastle.jce.provider.JCEKeyGenerator$DESede3");
        this.put("KeyGenerator.DESEDEWRAP", "org.bouncycastle.jce.provider.JCEKeyGenerator$DESede");
        this.put("KeyGenerator.SKIPJACK", "org.bouncycastle.jce.provider.JCEKeyGenerator$Skipjack");
        this.put("KeyGenerator.BLOWFISH", "org.bouncycastle.jce.provider.JCEKeyGenerator$Blowfish");
        this.put("KeyGenerator.TWOFISH", "org.bouncycastle.jce.provider.JCEKeyGenerator$Twofish");
        this.put("KeyGenerator.RC2", "org.bouncycastle.jce.provider.JCEKeyGenerator$RC2");
        this.put("KeyGenerator.1.2.840.113549.3.2", "org.bouncycastle.jce.provider.JCEKeyGenerator$RC2");
        this.put("KeyGenerator.RC4", "org.bouncycastle.jce.provider.JCEKeyGenerator$RC4");
        this.put("Alg.Alias.KeyGenerator.ARC4", "RC4");
        this.put("Alg.Alias.KeyGenerator.1.2.840.113549.3.4", "RC4");
        this.put("KeyGenerator.RC5", "org.bouncycastle.jce.provider.JCEKeyGenerator$RC5");
        this.put("Alg.Alias.KeyGenerator.RC5-32", "RC5");
        this.put("KeyGenerator.RC5-64", "org.bouncycastle.jce.provider.JCEKeyGenerator$RC564");
        this.put("KeyGenerator.RC6", "org.bouncycastle.jce.provider.JCEKeyGenerator$RC6");
        this.put("KeyGenerator.RIJNDAEL", "org.bouncycastle.jce.provider.JCEKeyGenerator$Rijndael");
        this.put("KeyGenerator.AES", "org.bouncycastle.jce.provider.JCEKeyGenerator$AES");
        this.put("KeyGenerator.2.16.840.1.101.3.4.2", "org.bouncycastle.jce.provider.JCEKeyGenerator$AES128");
        this.put("KeyGenerator.2.16.840.1.101.3.4.22", "org.bouncycastle.jce.provider.JCEKeyGenerator$AES192");
        this.put("KeyGenerator.2.16.840.1.101.3.4.42", "org.bouncycastle.jce.provider.JCEKeyGenerator$AES256");
        this.put("KeyGenerator.2.16.840.1.101.3.4.1.2", "org.bouncycastle.jce.provider.JCEKeyGenerator$AES128");
        this.put("KeyGenerator.2.16.840.1.101.3.4.1.22", "org.bouncycastle.jce.provider.JCEKeyGenerator$AES192");
        this.put("KeyGenerator.2.16.840.1.101.3.4.1.42", "org.bouncycastle.jce.provider.JCEKeyGenerator$AES256");
        this.put("KeyGenerator.AESWRAP", "org.bouncycastle.jce.provider.JCEKeyGenerator$AES");
        this.put("KeyGenerator.SERPENT", "org.bouncycastle.jce.provider.JCEKeyGenerator$Serpent");
        this.put("KeyGenerator.CAST5", "org.bouncycastle.jce.provider.JCEKeyGenerator$CAST5");
        this.put("KeyGenerator.1.2.840.113533.7.66.10", "org.bouncycastle.jce.provider.JCEKeyGenerator$CAST5");
        this.put("KeyGenerator.CAST6", "org.bouncycastle.jce.provider.JCEKeyGenerator$CAST6");
        this.put("KeyGenerator.IDEA", "org.bouncycastle.jce.provider.JCEKeyGenerator$IDEA");
        this.put("KeyGenerator.1.3.6.1.4.1.188.7.1.1.2", "org.bouncycastle.jce.provider.JCEKeyGenerator$IDEA");
        this.put("KeyGenerator.HMACMD2", "org.bouncycastle.jce.provider.JCEKeyGenerator$MD2HMAC");
        this.put("KeyGenerator.HMACMD4", "org.bouncycastle.jce.provider.JCEKeyGenerator$MD4HMAC");
        this.put("KeyGenerator.HMACMD5", "org.bouncycastle.jce.provider.JCEKeyGenerator$MD5HMAC");
        this.put("KeyGenerator.HMACRIPEMD128", "org.bouncycastle.jce.provider.JCEKeyGenerator$RIPEMD128HMAC");
        this.put("KeyGenerator.HMACRIPEMD160", "org.bouncycastle.jce.provider.JCEKeyGenerator$RIPEMD160HMAC");
        this.put("KeyGenerator.HMACSHA1", "org.bouncycastle.jce.provider.JCEKeyGenerator$HMACSHA1");
        this.put("KeyGenerator.HMACTIGER", "org.bouncycastle.jce.provider.JCEKeyGenerator$HMACTIGER");
        this.put("KeyPairGenerator.RSA", "org.bouncycastle.jce.provider.JDKKeyPairGenerator$RSA");
        this.put("KeyPairGenerator.DH", "org.bouncycastle.jce.provider.JDKKeyPairGenerator$DH");
        this.put("KeyPairGenerator.DSA", "org.bouncycastle.jce.provider.JDKKeyPairGenerator$DSA");
        this.put("KeyPairGenerator.ELGAMAL", "org.bouncycastle.jce.provider.JDKKeyPairGenerator$ElGamal");
        this.put("KeyPairGenerator.ECDSA", "org.bouncycastle.jce.provider.JDKKeyPairGenerator$ECDSA");
        this.put("KeyPairGenerator.ECDH", "org.bouncycastle.jce.provider.JDKKeyPairGenerator$ECDH");
        this.put("KeyPairGenerator.ECDHC", "org.bouncycastle.jce.provider.JDKKeyPairGenerator$ECDHC");
        this.put("KeyPairGenerator.ECIES", "org.bouncycastle.jce.provider.JDKKeyPairGenerator$ECDH");
        this.put("Alg.Alias.KeyPairGenerator.1.2.840.113549.1.1.1", "RSA");
        this.put("KeyFactory.RSA", "org.bouncycastle.jce.provider.JDKKeyFactory$RSA");
        this.put("KeyFactory.DH", "org.bouncycastle.jce.provider.JDKKeyFactory$DH");
        this.put("KeyFactory.DSA", "org.bouncycastle.jce.provider.JDKKeyFactory$DSA");
        this.put("KeyFactory.ELGAMAL", "org.bouncycastle.jce.provider.JDKKeyFactory$ElGamal");
        this.put("KeyFactory.ElGamal", "org.bouncycastle.jce.provider.JDKKeyFactory$ElGamal");
        this.put("KeyFactory.EC", "org.bouncycastle.jce.provider.JDKKeyFactory$EC");
        this.put("KeyFactory.ECDSA", "org.bouncycastle.jce.provider.JDKKeyFactory$ECDSA");
        this.put("KeyFactory.ECDH", "org.bouncycastle.jce.provider.JDKKeyFactory$ECDH");
        this.put("KeyFactory.ECDHC", "org.bouncycastle.jce.provider.JDKKeyFactory$ECDHC");
        this.put("Alg.Alias.KeyFactory.1.2.840.113549.1.1.1", "RSA");
        this.put("Alg.Alias.KeyFactory.1.2.840.10040.4.1", "DSA");
        this.put("AlgorithmParameters.DES", "org.bouncycastle.jce.provider.JDKAlgorithmParameters$IVAlgorithmParameters");
        this.put("Alg.Alias.AlgorithmParameters.1.3.14.3.2.7", "DES");
        this.put("AlgorithmParameters.DESEDE", "org.bouncycastle.jce.provider.JDKAlgorithmParameters$IVAlgorithmParameters");
        this.put("AlgorithmParameters.1.2.840.113549.3.7", "org.bouncycastle.jce.provider.JDKAlgorithmParameters$IVAlgorithmParameters");
        this.put("AlgorithmParameters.RC2", "org.bouncycastle.jce.provider.JDKAlgorithmParameters$RC2AlgorithmParameters");
        this.put("AlgorithmParameters.1.2.840.113549.3.2", "org.bouncycastle.jce.provider.JDKAlgorithmParameters$RC2AlgorithmParameters");
        this.put("AlgorithmParameters.RC5", "org.bouncycastle.jce.provider.JDKAlgorithmParameters$IVAlgorithmParameters");
        this.put("AlgorithmParameters.RC6", "org.bouncycastle.jce.provider.JDKAlgorithmParameters$IVAlgorithmParameters");
        this.put("AlgorithmParameters.IDEA", "org.bouncycastle.jce.provider.JDKAlgorithmParameters$IDEAAlgorithmParameters");
        this.put("AlgorithmParameters.BLOWFISH", "org.bouncycastle.jce.provider.JDKAlgorithmParameters$IVAlgorithmParameters");
        this.put("AlgorithmParameters.TWOFISH", "org.bouncycastle.jce.provider.JDKAlgorithmParameters$IVAlgorithmParameters");
        this.put("AlgorithmParameters.SKIPJACK", "org.bouncycastle.jce.provider.JDKAlgorithmParameters$IVAlgorithmParameters");
        this.put("AlgorithmParameters.RIJNDAEL", "org.bouncycastle.jce.provider.JDKAlgorithmParameters$IVAlgorithmParameters");
        this.put("AlgorithmParameters.AES", "org.bouncycastle.jce.provider.JDKAlgorithmParameters$IVAlgorithmParameters");
        this.put("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.2", "AES");
        this.put("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.22", "AES");
        this.put("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.42", "AES");
        this.put("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.1.2", "AES");
        this.put("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.1.22", "AES");
        this.put("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.1.42", "AES");
        this.put("SecretKeyFactory.PBE/PKCS5", "org.bouncycastle.jce.provider.JCESecretKeyFactory$PBE_PKCS5");
        this.put("SecretKeyFactory.PBE/PKCS12", "org.bouncycastle.jce.provider.JCESecretKeyFactory$PBE_PKCS12");
        this.put("SecretKeyFactory.DES", "org.bouncycastle.jce.provider.JCESecretKeyFactory$DES");
        this.put("SecretKeyFactory.DESEDE", "org.bouncycastle.jce.provider.JCESecretKeyFactory$DESede");
        this.put("SecretKeyFactory.DESEDE", "org.bouncycastle.jce.provider.JCESecretKeyFactory$DESede");
        this.put("Alg.Alias.SecretKeyFactory.PBE", "PBE/PKCS5");
        this.put("Alg.Alias.SecretKeyFactory.PBEWITHMD5ANDDES", "PBE/PKCS5");
        this.put("Alg.Alias.SecretKeyFactory.BROKENPBEWITHMD5ANDDES", "PBE/PKCS5");
        this.put("Alg.Alias.SecretKeyFactory.PBEWITHMD5ANDRC2", "PBE/PKCS5");
        this.put("Alg.Alias.SecretKeyFactory.PBEWITHSHA1ANDDES", "PBE/PKCS5");
        this.put("Alg.Alias.SecretKeyFactory.BROKENPBEWITHSHA1ANDDES", "PBE/PKCS5");
        this.put("Alg.Alias.SecretKeyFactory.PBEWITHSHA1ANDRC2", "PBE/PKCS5");
        this.put("Alg.Alias.SecretKeyFactory.PBEWITHSHAAND3-KEYTRIPLEDES-CBC", "PBE/PKCS12");
        this.put("Alg.Alias.SecretKeyFactory.OLDPBEWITHSHAAND3-KEYTRIPLEDES-CBC", "PBE/PKCS12");
        this.put("Alg.Alias.SecretKeyFactory.BROKENPBEWITHSHAAND3-KEYTRIPLEDES-CBC", "PBE/PKCS12");
        this.put("Alg.Alias.SecretKeyFactory.PBEWITHSHAAND2-KEYTRIPLEDES-CBC", "PBE/PKCS12");
        this.put("Alg.Alias.SecretKeyFactory.BROKENPBEWITHSHAAND2-KEYTRIPLEDES-CBC", "PBE/PKCS12");
        this.put("Alg.Alias.SecretKeyFactory.PBEWITHSHAAND128BITRC4", "PBE/PKCS12");
        this.put("Alg.Alias.SecretKeyFactory.PBEWITHSHAAND40BITRC4", "PBE/PKCS12");
        this.put("Alg.Alias.SecretKeyFactory.PBEWITHSHAAND128BITRC2-CBC", "PBE/PKCS12");
        this.put("Alg.Alias.SecretKeyFactory.PBEWITHSHAAND40BITRC2-CBC", "PBE/PKCS12");
        this.put("Alg.Alias.SecretKeyFactory.PBEWITHSHAANDTWOFISH-CBC", "PBE/PKCS12");
        this.put("Alg.Alias.SecretKeyFactory.OLDPBEWITHSHAANDTWOFISH-CBC", "PBE/PKCS12");
        this.put("Alg.Alias.SecretKeyFactory.PBEWITHSHAANDIDEA-CBC", "PBE/PKCS12");
        this.put("Alg.Alias.SecretKeyFactory.PBEWITHHMACSHA", "PBE/PKCS12");
        this.put("Alg.Alias.SecretKeyFactory.PBEWITHHMACRIPEMD160", "PBE/PKCS12");
        this.put("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.1", "PBE/PKCS12");
        this.put("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.2", "PBE/PKCS12");
        this.put("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.3", "PBE/PKCS12");
        this.put("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.4", "PBE/PKCS12");
        this.put("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.5", "PBE/PKCS12");
        this.put("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.6", "PBE/PKCS12");
        this.put("Alg.Alias.SecretKeyFactory.1.3.14.3.2.26", "PBE/PKCS12");
        this.put("Mac.DESMAC", "org.bouncycastle.jce.provider.JCEMac$DES");
        this.put("Alg.Alias.Mac.DES", "DESMAC");
        this.put("Mac.DESMAC/CFB8", "org.bouncycastle.jce.provider.JCEMac$DESCFB8");
        this.put("Alg.Alias.Mac.DES/CFB8", "DESMAC/CFB8");
        this.put("Mac.DESEDEMAC", "org.bouncycastle.jce.provider.JCEMac$DESede");
        this.put("Alg.Alias.Mac.DESEDE", "DESEDEMAC");
        this.put("Mac.DESEDEMAC/CFB8", "org.bouncycastle.jce.provider.JCEMac$DESedeCFB8");
        this.put("Alg.Alias.Mac.DESEDE/CFB8", "DESEDEMAC/CFB8");
        this.put("Mac.SKIPJACKMAC", "org.bouncycastle.jce.provider.JCEMac$Skipjack");
        this.put("Alg.Alias.Mac.SKIPJACK", "SKIPJACKMAC");
        this.put("Mac.SKIPJACKMAC/CFB8", "org.bouncycastle.jce.provider.JCEMac$SkipjackCFB8");
        this.put("Alg.Alias.Mac.SKIPJACK/CFB8", "SKIPJACKMAC/CFB8");
        this.put("Mac.IDEAMAC", "org.bouncycastle.jce.provider.JCEMac$IDEA");
        this.put("Alg.Alias.Mac.IDEA", "IDEAMAC");
        this.put("Mac.IDEAMAC/CFB8", "org.bouncycastle.jce.provider.JCEMac$IDEACFB8");
        this.put("Alg.Alias.Mac.IDEA/CFB8", "IDEAMAC/CFB8");
        this.put("Mac.RC2MAC", "org.bouncycastle.jce.provider.JCEMac$RC2");
        this.put("Alg.Alias.Mac.RC2", "RC2MAC");
        this.put("Mac.RC2MAC/CFB8", "org.bouncycastle.jce.provider.JCEMac$RC2CFB8");
        this.put("Alg.Alias.Mac.RC2/CFB8", "RC2MAC/CFB8");
        this.put("Mac.RC5MAC", "org.bouncycastle.jce.provider.JCEMac$RC5");
        this.put("Alg.Alias.Mac.RC5", "RC5MAC");
        this.put("Mac.RC5MAC/CFB8", "org.bouncycastle.jce.provider.JCEMac$RC5CFB8");
        this.put("Alg.Alias.Mac.RC5/CFB8", "RC5MAC/CFB8");
        this.put("Mac.HMACMD2", "org.bouncycastle.jce.provider.JCEMac$MD2");
        this.put("Alg.Alias.Mac.HMAC-MD2", "HMACMD2");
        this.put("Alg.Alias.Mac.HMAC/MD2", "HMACMD2");
        this.put("Mac.HMACMD4", "org.bouncycastle.jce.provider.JCEMac$MD4");
        this.put("Alg.Alias.Mac.HMAC-MD4", "HMACMD4");
        this.put("Alg.Alias.Mac.HMAC/MD4", "HMACMD4");
        this.put("Mac.HMACMD5", "org.bouncycastle.jce.provider.JCEMac$MD5");
        this.put("Alg.Alias.Mac.HMAC-MD5", "HMACMD5");
        this.put("Alg.Alias.Mac.HMAC/MD5", "HMACMD5");
        this.put("Mac.HMACRIPEMD128", "org.bouncycastle.jce.provider.JCEMac$RIPEMD128");
        this.put("Alg.Alias.Mac.HMAC-RIPEMD128", "HMACRIPEMD128");
        this.put("Alg.Alias.Mac.HMAC/RIPEMD128", "HMACRIPEMD128");
        this.put("Mac.HMACRIPEMD160", "org.bouncycastle.jce.provider.JCEMac$RIPEMD160");
        this.put("Alg.Alias.Mac.HMAC-RIPEMD160", "HMACRIPEMD160");
        this.put("Alg.Alias.Mac.HMAC/RIPEMD160", "HMACRIPEMD160");
        this.put("Mac.HMACSHA1", "org.bouncycastle.jce.provider.JCEMac$SHA1");
        this.put("Alg.Alias.Mac.HMAC-SHA1", "HMACSHA1");
        this.put("Alg.Alias.Mac.HMAC/SHA1", "HMACSHA1");
        this.put("Mac.HMACSHA256", "org.bouncycastle.jce.provider.JCEMac$SHA256");
        this.put("Alg.Alias.Mac.HMAC-SHA256", "HMACSHA256");
        this.put("Alg.Alias.Mac.HMAC/SHA256", "HMACSHA256");
        this.put("Mac.HMACSHA384", "org.bouncycastle.jce.provider.JCEMac$SHA384");
        this.put("Alg.Alias.Mac.HMAC-SHA384", "HMACSHA384");
        this.put("Alg.Alias.Mac.HMAC/SHA384", "HMACSHA384");
        this.put("Mac.HMACSHA512", "org.bouncycastle.jce.provider.JCEMac$SHA512");
        this.put("Alg.Alias.Mac.HMAC-SHA512", "HMACSHA512");
        this.put("Alg.Alias.Mac.HMAC/SHA512", "HMACSHA512");
        this.put("Mac.HMACTiger", "org.bouncycastle.jce.provider.JCEMac$Tiger");
        this.put("Alg.Alias.Mac.HMAC-Tiger", "HMACTiger");
        this.put("Alg.Alias.Mac.HMAC/Tiger", "HMACTiger");
        this.put("Mac.PBEWITHHMACSHA", "org.bouncycastle.jce.provider.JCEMac$PBEWithSHA");
        this.put("Mac.PBEWITHHMACRIPEMD160", "org.bouncycastle.jce.provider.JCEMac$PBEWithRIPEMD160");
        this.put("Alg.Alias.Mac.1.3.14.3.2.26", "PBEWITHHMACSHA");
        this.put("MessageDigest.SHA-1", "org.bouncycastle.jce.provider.JDKMessageDigest$SHA1");
        this.put("Alg.Alias.MessageDigest.SHA1", "SHA-1");
        this.put("Alg.Alias.MessageDigest.SHA", "SHA-1");
        this.put("Alg.Alias.MessageDigest.1.3.14.3.2.26", "SHA-1");
        this.put("MessageDigest.SHA-256", "org.bouncycastle.jce.provider.JDKMessageDigest$SHA256");
        this.put("MessageDigest.SHA-384", "org.bouncycastle.jce.provider.JDKMessageDigest$SHA384");
        this.put("MessageDigest.SHA-512", "org.bouncycastle.jce.provider.JDKMessageDigest$SHA512");
        this.put("MessageDigest.MD2", "org.bouncycastle.jce.provider.JDKMessageDigest$MD2");
        this.put("MessageDigest.MD4", "org.bouncycastle.jce.provider.JDKMessageDigest$MD4");
        this.put("MessageDigest.MD5", "org.bouncycastle.jce.provider.JDKMessageDigest$MD5");
        this.put("MessageDigest.1.2.840.113549.2.5", "org.bouncycastle.jce.provider.JDKMessageDigest$MD5");
        this.put("MessageDigest.RIPEMD128", "org.bouncycastle.jce.provider.JDKMessageDigest$RIPEMD128");
        this.put("MessageDigest.RIPEMD160", "org.bouncycastle.jce.provider.JDKMessageDigest$RIPEMD160");
        this.put("MessageDigest.RIPEMD256", "org.bouncycastle.jce.provider.JDKMessageDigest$RIPEMD256");
        this.put("MessageDigest.RIPEMD320", "org.bouncycastle.jce.provider.JDKMessageDigest$RIPEMD320");
        this.put("MessageDigest.Tiger", "org.bouncycastle.jce.provider.JDKMessageDigest$Tiger");
        this.put("Signature.MD2WithRSAEncryption", "org.bouncycastle.jce.provider.JDKDigestSignature$MD2WithRSAEncryption");
        this.put("Signature.MD5WithRSAEncryption", "org.bouncycastle.jce.provider.JDKDigestSignature$MD5WithRSAEncryption");
        this.put("Signature.SHA1WithRSAEncryption", "org.bouncycastle.jce.provider.JDKDigestSignature$SHA1WithRSAEncryption");
        this.put("Signature.RIPEMD160WithRSAEncryption", "org.bouncycastle.jce.provider.JDKDigestSignature$RIPEMD160WithRSAEncryption");
        this.put("Signature.RIPEMD128WithRSAEncryption", "org.bouncycastle.jce.provider.JDKDigestSignature$RIPEMD128WithRSAEncryption");
        this.put("Signature.RIPEMD256WithRSAEncryption", "org.bouncycastle.jce.provider.JDKDigestSignature$RIPEMD256WithRSAEncryption");
        this.put("Signature.DSA", "org.bouncycastle.jce.provider.JDKDSASigner$stdDSA");
        this.put("Signature.ECDSA", "org.bouncycastle.jce.provider.JDKDSASigner$ecDSA");
        this.put("Signature.SHA1withRSA/ISO9796-2", "org.bouncycastle.jce.provider.JDKISOSignature$SHA1WithRSAEncryption");
        this.put("Signature.MD5withRSA/ISO9796-2", "org.bouncycastle.jce.provider.JDKISOSignature$MD5WithRSAEncryption");
        this.put("Signature.RIPEMD160withRSA/ISO9796-2", "org.bouncycastle.jce.provider.JDKISOSignature$RIPEMD160WithRSAEncryption");
        this.put("Signature.SHA1withRSA/PSS", "org.bouncycastle.jce.provider.JDKPSSSigner$SHA1withRSA");
        this.put("Signature.SHA256withRSA/PSS", "org.bouncycastle.jce.provider.JDKPSSSigner$SHA256withRSA");
        this.put("Signature.SHA384withRSA/PSS", "org.bouncycastle.jce.provider.JDKPSSSigner$SHA384withRSA");
        this.put("Signature.SHA512withRSA/PSS", "org.bouncycastle.jce.provider.JDKPSSSigner$SHA512withRSA");
        this.put("Alg.Alias.Signature.MD2withRSAEncryption", "MD2WithRSAEncryption");
        this.put("Alg.Alias.Signature.MD5withRSAEncryption", "MD5WithRSAEncryption");
        this.put("Alg.Alias.Signature.SHA1withRSAEncryption", "SHA1WithRSAEncryption");
        this.put("Alg.Alias.Signature.SHA256withRSAEncryption", "SHA256withRSA/PSS");
        this.put("Alg.Alias.Signature.SHA384withRSAEncryption", "SHA384withRSA/PSS");
        this.put("Alg.Alias.Signature.SHA512withRSAEncryption", "SHA512withRSA/PSS");
        this.put("Alg.Alias.Signature.SHA256WithRSAEncryption", "SHA256withRSA/PSS");
        this.put("Alg.Alias.Signature.SHA384WithRSAEncryption", "SHA384withRSA/PSS");
        this.put("Alg.Alias.Signature.SHA512WithRSAEncryption", "SHA512withRSA/PSS");
        this.put("Alg.Alias.Signature.SHA256WITHRSAENCRYPTION", "SHA256withRSA/PSS");
        this.put("Alg.Alias.Signature.SHA384WITHRSAENCRYPTION", "SHA384withRSA/PSS");
        this.put("Alg.Alias.Signature.SHA512WITHRSAENCRYPTION", "SHA512withRSA/PSS");
        this.put("Alg.Alias.Signature.RIPEMD160withRSAEncryption", "RIPEMD160WithRSAEncryption");
        this.put("Alg.Alias.Signature.1.2.840.113549.1.1.2", "MD2WithRSAEncryption");
        this.put("Alg.Alias.Signature.MD2WithRSA", "MD2WithRSAEncryption");
        this.put("Alg.Alias.Signature.MD2withRSA", "MD2WithRSAEncryption");
        this.put("Alg.Alias.Signature.MD2/RSA", "MD2WithRSAEncryption");
        this.put("Alg.Alias.Signature.MD5WithRSA", "MD5WithRSAEncryption");
        this.put("Alg.Alias.Signature.MD5withRSA", "MD5WithRSAEncryption");
        this.put("Alg.Alias.Signature.MD5/RSA", "MD5WithRSAEncryption");
        this.put("Alg.Alias.Signature.1.2.840.113549.1.1.4", "MD5WithRSAEncryption");
        this.put("Alg.Alias.Signature.SHA1WithRSA", "SHA1WithRSAEncryption");
        this.put("Alg.Alias.Signature.SHA1withRSA", "SHA1WithRSAEncryption");
        this.put("Alg.Alias.Signature.SHA1/RSA", "SHA1WithRSAEncryption");
        this.put("Alg.Alias.Signature.SHA-1/RSA", "SHA1WithRSAEncryption");
        this.put("Alg.Alias.Signature.1.2.840.113549.1.1.5", "SHA1WithRSAEncryption");
        this.put("Alg.Alias.Signature.1.3.14.3.2.26with1.2.840.113549.1.1.1", "SHA1WithRSAEncryption");
        this.put("Alg.Alias.Signature.1.3.14.3.2.26with1.2.840.113549.1.1.5", "SHA1WithRSAEncryption");
        this.put("Alg.Alias.Signature.1.2.840.113549.2.5with1.2.840.113549.1.1.1", "MD5WithRSAEncryption");
        this.put("Alg.Alias.Signature.RIPEMD160WithRSA", "RIPEMD160WithRSAEncryption");
        this.put("Alg.Alias.Signature.RIPEMD160withRSA", "RIPEMD160WithRSAEncryption");
        this.put("Alg.Alias.Signature.RIPEMD128WithRSA", "RIPEMD128WithRSAEncryption");
        this.put("Alg.Alias.Signature.RIPEMD128withRSA", "RIPEMD128WithRSAEncryption");
        this.put("Alg.Alias.Signature.RIPEMD256WithRSA", "RIPEMD256WithRSAEncryption");
        this.put("Alg.Alias.Signature.RIPEMD256withRSA", "RIPEMD256WithRSAEncryption");
        this.put("Alg.Alias.Signature.RIPEMD-160/RSA", "RIPEMD160WithRSAEncryption");
        this.put("Alg.Alias.Signature.RMD160withRSA", "RIPEMD160WithRSAEncryption");
        this.put("Alg.Alias.Signature.RMD160/RSA", "RIPEMD160WithRSAEncryption");
        this.put("Alg.Alias.Signature.1.3.36.3.3.1.2", "RIPEMD160WithRSAEncryption");
        this.put("Alg.Alias.Signature.1.3.36.3.3.1.3", "RIPEMD128WithRSAEncryption");
        this.put("Alg.Alias.Signature.1.3.36.3.3.1.4", "RIPEMD256WithRSAEncryption");
        this.put("Alg.Alias.Signature.MD2WITHRSAENCRYPTION", "MD2WithRSAEncryption");
        this.put("Alg.Alias.Signature.MD5WITHRSAENCRYPTION", "MD5WithRSAEncryption");
        this.put("Alg.Alias.Signature.SHA1WITHRSAENCRYPTION", "SHA1WithRSAEncryption");
        this.put("Alg.Alias.Signature.RIPEMD160WITHRSAENCRYPTION", "RIPEMD160WithRSAEncryption");
        this.put("Alg.Alias.Signature.MD5WITHRSA", "MD5WithRSAEncryption");
        this.put("Alg.Alias.Signature.SHA1WITHRSA", "SHA1WithRSAEncryption");
        this.put("Alg.Alias.Signature.RIPEMD160WITHRSA", "RIPEMD160WithRSAEncryption");
        this.put("Alg.Alias.Signature.RMD160WITHRSA", "RIPEMD160WithRSAEncryption");
        this.put("Alg.Alias.Signature.RIPEMD160WITHRSA", "RIPEMD160WithRSAEncryption");
        this.put("Alg.Alias.Signature.SHA1withECDSA", "ECDSA");
        this.put("Alg.Alias.Signature.ECDSAwithSHA1", "ECDSA");
        this.put("Alg.Alias.Signature.SHA1WITHECDSA", "ECDSA");
        this.put("Alg.Alias.Signature.ECDSAWITHSHA1", "ECDSA");
        this.put("Alg.Alias.Signature.SHA1WithECDSA", "ECDSA");
        this.put("Alg.Alias.Signature.ECDSAWithSHA1", "ECDSA");
        this.put("Alg.Alias.Signature.1.2.840.10045.4.1", "ECDSA");
        this.put("Alg.Alias.Signature.SHA/DSA", "DSA");
        this.put("Alg.Alias.Signature.SHA1withDSA", "DSA");
        this.put("Alg.Alias.Signature.SHA1WITHDSA", "DSA");
        this.put("Alg.Alias.Signature.1.3.14.3.2.26with1.2.840.10040.4.1", "DSA");
        this.put("Alg.Alias.Signature.1.3.14.3.2.26with1.2.840.10040.4.3", "DSA");
        this.put("Alg.Alias.Signature.DSAwithSHA1", "DSA");
        this.put("Alg.Alias.Signature.DSAWITHSHA1", "DSA");
        this.put("Alg.Alias.Signature.SHA1WithDSA", "DSA");
        this.put("Alg.Alias.Signature.DSAWithSHA1", "DSA");
        this.put("Alg.Alias.Signature.1.2.840.10040.4.3", "DSA");
        this.put("Alg.Alias.Signature.MD5WithRSA/ISO9796-2", "MD5withRSA/ISO9796-2");
        this.put("Alg.Alias.Signature.SHA1WithRSA/ISO9796-2", "SHA1withRSA/ISO9796-2");
        this.put("Alg.Alias.Signature.RIPEMD160WithRSA/ISO9796-2", "RIPEMD160withRSA/ISO9796-2");
        this.put("CertPathValidator.PKIX", "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi");
        this.put("CertPathValidator.PKIX ValidationAlgorithm", "RFC2459");
        this.put("CertPathBuilder.PKIX", "org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi");
        this.put("CertPathBuilder.PKIX ValidationAlgorithm", "RFC2459");
        this.put("CertStore.Collection", "org.bouncycastle.jce.provider.CertStoreCollectionSpi");
    }
}