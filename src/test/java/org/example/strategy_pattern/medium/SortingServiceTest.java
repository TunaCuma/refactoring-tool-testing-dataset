package org.example.strategy_pattern.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class SortingServiceTest {
    @Test
    void testBubbleSort() {
        SortingService ss = new SortingService();
        int[] data = {3,1,2};
        assertArrayEquals(new int[]{1,2,3}, ss.sort("BUBBLE", data));
    }
    @Test
    void testDefaultSort() {
        SortingService ss = new SortingService();
        int[] data = {2,1};
        assertArrayEquals(new int[]{1,2}, ss.sort("UNKNOWN", data));
    }
}
