package org.example.long_method.hard;

public class ReportScheduler {
    /**
     * Reads schedule config, computes next run times, triggers reports,
     * logs schedules, and returns summary.
     */
    public String schedule(java.util.List<java.util.Map<String,Object>> jobs) {
        java.util.List<String> ran = new java.util.ArrayList<>();
        for (var job : jobs) {
            String name = (String) job.get("name");
            String cron = (String) job.get("cron");
            // stub: always run once
            ran.add("Ran:" + name + "@" + cron);
            java.util.Map<String,Object> log = new java.util.HashMap<>();
            log.put("job", name); log.put("time", System.currentTimeMillis());
            // pretend to write log
        }
        return String.join(";", ran);
    }
}
