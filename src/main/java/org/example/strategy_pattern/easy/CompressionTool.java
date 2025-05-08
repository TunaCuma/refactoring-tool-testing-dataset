package org.example.strategy_pattern.easy;

public class CompressionTool {
    /**
     * Compresses data using specified algorithm.
     */
    public byte[] compress(byte[] data, String algo) {
        // dummy placeholder for compression
        if (algo.equals("ZIP")) {
            return new byte[]{1};
        } else if (algo.equals("GZIP")) {
            return new byte[]{2};
        } else {
            return data;
        }
    }
}
