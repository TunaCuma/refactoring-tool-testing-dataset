package org.example.feature_envy.hard;

import java.util.*;

public class ScheduleFormatter {
    /**
     * Formats schedule slots into a human-readable list.
     */
    public String formatSchedule(Schedule schedule) {
        if (schedule == null || schedule.getSlots() == null) {
            return "No schedule";
        }
        StringBuilder sb = new StringBuilder("Schedule:\n");
        for (Slot s : schedule.getSlots()) {
            sb.append(s.getDay()).append(": ")
              .append(s.getStartTime()).append("-").append(s.getEndTime())
              .append("\n");
        }
        return sb.toString().trim();
    }
}

class Schedule {
    private final List<Slot> slots;
    public Schedule(List<Slot> slots) { this.slots = slots; }
    public List<Slot> getSlots() { return slots; }
}

class Slot {
    private final String day, startTime, endTime;
    public Slot(String day, String startTime, String endTime) {
        this.day = day; this.startTime = startTime; this.endTime = endTime;
    }
    public String getDay() { return day; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }
}
