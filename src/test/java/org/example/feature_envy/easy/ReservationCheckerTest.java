package org.example.feature_envy.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ReservationCheckerTest {
    @Test
    void testCanReserveTrue() {
        Reservation r = new Reservation(5);
        assertTrue(new ReservationChecker().canReserve(r, 3));
    }
    @Test
    void testCanReserveFalse() {
        Reservation r = new Reservation(2);
        assertFalse(new ReservationChecker().canReserve(r, 4));
    }
}
