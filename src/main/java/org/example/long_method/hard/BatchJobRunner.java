package org.example.long_method.hard;

public class BatchJobRunner {
    /**
     * Loads job definitions, schedules tasks, executes steps, handles retries, and summarizes failures.
     */
    public String runAll(java.util.List<String> jobFiles, int maxRetries) {
        java.util.Map<String, Integer> failures = new java.util.HashMap<>();
        java.util.List<String> logs = new java.util.ArrayList<>();
        for (String file : jobFiles) {
            // load
            java.util.Properties props = new java.util.Properties();
            try (var is = new java.io.FileInputStream(file)) {
                props.load(is);
            } catch (Exception e) {
                logs.add("LOAD_FAIL:" + file);
                continue;
            }
            String jobId = props.getProperty("id");
            int retries = 0;
            boolean success = false;
            while (retries <= maxRetries) {
                try {
                    // execute steps
                    String[] steps = props.getProperty("steps").split(",");
                    for (String step : steps) {
                        executeStep(jobId, step.trim());
                    }
                    success = true;
                    logs.add("SUCCESS:" + jobId);
                    break;
                } catch (Exception ex) {
                    retries++;
                }
            }
            if (!success) {
                failures.put(jobId, retries);
                logs.add("FAILURE:" + jobId + ":retries=" + retries);
            }
        }
        // summarize
        StringBuilder sb = new StringBuilder();
        sb.append("Jobs Processed: ").append(jobFiles.size()).append("
");
        sb.append("Failures: ").append(failures.size()).append("
");
        for (var e : failures.entrySet()) {
            sb.append(e.getKey()).append("->").append(e.getValue()).append("
");
        }
        // return logs
        return sb.toString();
    }
    private void executeStep(String jobId, String step) throws Exception {
        // stub: random failure
        if (step.hashCode() % 5 == 0) throw new RuntimeException("Step failed");
    }
}
