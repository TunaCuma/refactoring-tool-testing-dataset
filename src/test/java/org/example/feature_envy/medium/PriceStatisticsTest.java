package org.example.feature_envy.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class PriceStatisticsTest {
    @Test
    void testSummarize() {
        Catalog c = new Catalog(new double[]{10, 20, 30});
        assertEquals("min=10.00,max=30.00,avg=20.00", new PriceStatistics().summarize(c));
    }
    @Test
    void testSummarizeNoData() {
        assertEquals("No data", new PriceStatistics().summarize(null));
        assertEquals("No data", new PriceStatistics().summarize(new Catalog(new double[0])));
    }
}
