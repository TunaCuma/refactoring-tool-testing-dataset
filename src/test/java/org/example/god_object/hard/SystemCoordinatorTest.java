package org.example.god_object.hard;

import org.junit.jupiter.api.Test; import static org.junit.jupiter.api.Assertions.*;
class SystemCoordinatorTest {
    @Test
    void testStartStop() throws Exception {
        SystemCoordinator coord = new SystemCoordinator();
        // no config file -> exception expected
        assertThrows(Exception.class, coord::start);
    }
    @Test
    void testRecordMetric() {
        SystemCoordinator coord = new SystemCoordinator();
        coord.recordMetric("cpu", 50);
        assertEquals(50, coord.metrics.get("cpu"));
    }
}
