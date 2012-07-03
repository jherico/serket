package org.saintandreas.util;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;

import javax.crypto.Cipher;

import com.google.common.base.Charsets;

public class CryptoUtil {

    /**
     * returns the SHA-1 hash of the input
     * 
     */
    public static byte[] getHash(String algorithm, byte[] input) throws GeneralSecurityException {
        MessageDigest sha = MessageDigest.getInstance(algorithm);
        sha.reset();
        sha.update(input, 0, input.length);
        return sha.digest();
    }

    public static byte[] getHash(String algorithm, String input) throws GeneralSecurityException {
        return getHash(algorithm, input, Charsets.UTF_8);
    }

    public static byte[] getHash(String algorithm, String input, Charset charset) throws GeneralSecurityException {
        return getHash(algorithm, input.getBytes(charset));
    }

    public static boolean verifySignature(String cipherName, String hashName, byte[] signature, PublicKey signingKey, byte[] data) throws GeneralSecurityException { 
        Cipher cipher = Cipher.getInstance(cipherName);
        cipher.init(Cipher.DECRYPT_MODE, signingKey);
        return Arrays.equals(cipher.doFinal(signature), getHash(hashName, data));
    }

    public static byte[] signData(String cipherName, String hashName, byte[] data, PrivateKey signingKey) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(cipherName);
        cipher.init(Cipher.ENCRYPT_MODE, signingKey);
        return cipher.doFinal(getHash(hashName, data));
    }

}
