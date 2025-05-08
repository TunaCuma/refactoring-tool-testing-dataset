package org.example.strategy_pattern.hard;

public class EncryptionService {
    public String encrypt(String algorithm, String data) {
        if (algorithm.equals("AES")) {
            // dummy AES
            return "AES(" + data + ")";
        } else if (algorithm.equals("DES")) {
            return "DES(" + data + ")";
        } else if (algorithm.equals("RSA")) {
            return "RSA(" + data + ")";
        }
        return data;
    }
}
