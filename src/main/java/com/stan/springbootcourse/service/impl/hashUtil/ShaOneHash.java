package com.stan.springbootcourse.service.impl.hashUtil;

import lombok.extern.log4j.Log4j2;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Log4j2
public class ShaOneHash {
    private static final SecureRandom secureRandom = new SecureRandom();
    private final String  password = "89cce7126591aaf304083ee7f555ad4270c828c7";
    static String commonSalt = generateSalt();

    public static String generateFinalHash(String password) {
        //static String salt1 = null;
        try {
            //String salt = generateSalt();
             String salt = commonSalt;
            log.info("salt inside generateFinalHash...{}",salt);
            String initialHash =  hashWithSHA1(password);
            String finalString = salt + initialHash;
            String finalHash = hashWithSHA1(finalString);
            log.info("finalHash ...{}",finalHash);
            return finalHash;

        } catch (Exception e) {
           e.printStackTrace();
        }
        log.info("ail to generateFinalHash ...");
        return null;
    }

    public static String hashWithSHA1(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] bytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(bytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-1 algorithm not available", e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static String generateSalt() {
        StringBuilder sb = new StringBuilder(30);
        // First digit should not be 0
        sb.append(secureRandom.nextInt(9) + 1);
        for (int i = 1; i < 30; i++) {
            sb.append(secureRandom.nextInt(10)); // digits from 0 to 9
        }
        String commonSalt = sb.toString();
       // return sb.toString();
        log.info("salt inside generateSalt...{}",commonSalt);
        return commonSalt;
    }

    public static void main(String[] args) {
        //89cce7126591aaf304083ee7f555ad4270c828c7
        ShaOneHash shaOneHash = new ShaOneHash();
        System.out.println("The hash 1 is " + shaOneHash.hashWithSHA1("89cce7126591aaf304083ee7f555ad4270c828c7"));
        System.out.println("The hash 2 is " + shaOneHash.hashWithSHA1("89cce7126591aaf304083ee7f555ad4270c828c7"));
//
//        System.out.println("-----------------------------");
//
//        System.out.println("Random Salt: " + shaOneHash.generateSalt());

        System.out.println("-----------------------------");

        System.out.println("final hash: " + shaOneHash.generateFinalHash(shaOneHash.password));
    }
}

