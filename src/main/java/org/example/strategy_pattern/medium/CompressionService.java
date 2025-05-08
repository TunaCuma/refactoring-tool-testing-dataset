package org.example.strategy_pattern.medium;

public class CompressionService {
    public byte[] compress(String algorithm, byte[] data) {
        if ("ZIP".equals(algorithm)) {
            return new byte[data.length];
        } else if ("RAR".equals(algorithm)) {
            return new byte[data.length + 10];
        } else if ("TAR".equals(algorithm)) {
            return new byte[data.length + 5];
        }
        throw new UnsupportedOperationException("Algorithm not supported: " + algorithm);
    }
}
