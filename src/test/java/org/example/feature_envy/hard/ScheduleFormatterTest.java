package org.example.feature_envy.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class ScheduleFormatterTest {
    @Test
    void testFormatSchedule() {
        List<Slot> slots = Arrays.asList(
            new Slot("Mon","09:00","17:00"),
            new Slot("Tue","10:00","16:00")
        );
        Schedule schedule = new Schedule(slots);
        String res = new ScheduleFormatter().formatSchedule(schedule);
        assertTrue(res.contains("Mon: 09:00-17:00"));
        assertTrue(res.contains("Tue: 10:00-16:00"));
    }
    @Test
    void testFormatEmpty() {
        assertEquals("No schedule", new ScheduleFormatter().formatSchedule(null));
        assertEquals("No schedule", new ScheduleFormatter().formatSchedule(new Schedule(null)));
    }
}
