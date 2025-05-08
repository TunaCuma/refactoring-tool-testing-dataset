package org.example.strategy_pattern.easy;

public class SortingContext {
    /**
     * Sorts array based on algorithm name.
     */
    public int[] sort(int[] data, String algorithm) {
        int[] result = data.clone();
        if (algorithm.equals("BUBBLE")) {
            // bubble sort
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length - 1; j++) {
                    if (result[j] > result[j + 1]) {
                        int temp = result[j];
                        result[j] = result[j + 1];
                        result[j + 1] = temp;
                    }
                }
            }
        } else if (algorithm.equals("INSERTION")) {
            // insertion sort
            for (int i = 1; i < result.length; i++) {
                int key = result[i];
                int j = i - 1;
                while (j >= 0 && result[j] > key) {
                    result[j + 1] = result[j];
                    j--;
                }
                result[j + 1] = key;
            }
        }
        return result;
    }
}
