package org.example.strategy_pattern.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SortingContextTest {
    @Test
    void testBubbleSort() {
        SortingContext sc = new SortingContext();
        int[] input = {3,1,2};
        assertArrayEquals(new int[]{1,2,3}, sc.sort(input, "BUBBLE"));
    }

    @Test
    void testInsertionSort() {
        SortingContext sc = new SortingContext();
        int[] input = {3,1,2};
        assertArrayEquals(new int[]{1,2,3}, sc.sort(input, "INSERTION"));
    }
}
