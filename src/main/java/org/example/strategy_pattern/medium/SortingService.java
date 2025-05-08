package org.example.strategy_pattern.medium;

public class SortingService {
    public int[] sort(String algorithm, int[] data) {
        if ("BUBBLE".equals(algorithm)) {
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data.length - 1; j++) {
                    if (data[j] > data[j+1]) {
                        int tmp = data[j]; data[j] = data[j+1]; data[j+1] = tmp;
                    }
                }
            }
            return data;
        } else if ("QUICK".equals(algorithm)) {
            // simplified quick sort imitation
            java.util.Arrays.sort(data);
            return data;
        } else if ("MERGE".equals(algorithm)) {
            // fake merge for example
            java.util.Arrays.sort(data);
            return data;
        }
        return data;
    }
}
