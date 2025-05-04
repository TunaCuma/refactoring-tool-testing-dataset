package org.example.long_method.hard;

public class WorkflowOrchestrator {
    /**
     * Reads workflow definition, executes tasks in order, handles branching,
     * collects results, and returns status report.
     */
    public String execute(java.util.Map<String, java.util.List<String>> wf, String start) {
        java.util.Set<String> visited = new java.util.HashSet<>();
        java.util.List<String> report = new java.util.ArrayList<>();
        java.util.Deque<String> stack = new java.util.ArrayDeque<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            String task = stack.pop();
            if (visited.contains(task)) continue;
            visited.add(task);
            report.add("Start:" + task);
            // simulate execution
            report.add("Complete:" + task);
            var next = wf.getOrDefault(task, java.util.List.of());
            for (String n : next) stack.push(n);
        }
        return String.join("|", report);
    }
}
