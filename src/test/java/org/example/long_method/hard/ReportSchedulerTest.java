package org.example.long_method.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
class ReportSchedulerTest {
    @Test
    void testSchedule() {
        var job = Map.of("name","R1","cron","0 0 * * *");
        String out = new ReportScheduler().schedule(List.of(job));
        assertTrue(out.contains("Ran:R1@0 0 * * *"));
    }
}
