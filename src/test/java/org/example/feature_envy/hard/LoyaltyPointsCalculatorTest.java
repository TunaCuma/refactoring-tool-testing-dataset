package org.example.feature_envy.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class LoyaltyPointsCalculatorTest {
    @Test
    void testCalculatePoints() {
        List<Activity> acts = Arrays.asList(
            new Activity("purchase", 100),
            new Activity("review", 0),
            new Activity("referral", 0),
            new Activity("unknown", 5)
        );
        LoyaltyAccount acc = new LoyaltyAccount(acts);
        assertEquals(161, new LoyaltyPointsCalculator().calculatePoints(acc));
    }
    @Test
    void testCalculatePointsEmpty() {
        assertEquals(0, new LoyaltyPointsCalculator().calculatePoints(null));
        assertEquals(0, new LoyaltyPointsCalculator().calculatePoints(new LoyaltyAccount(null)));
    }
}
