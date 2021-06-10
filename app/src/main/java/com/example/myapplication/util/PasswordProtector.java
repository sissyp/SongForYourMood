package com.example.myapplication.util;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * PasswordProtector is responsible for creating an encrypted password for the user's input password.
 */

public class PasswordProtector {
    /**
     * hash function md5
     * @param message is the user's input password.
     * @return encrypted password for the given one.
     */
    public static String md5(String message) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(message.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            return "";
        }

    }
}
