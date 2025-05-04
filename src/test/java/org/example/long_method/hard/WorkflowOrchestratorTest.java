package org.example.long_method.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
class WorkflowOrchestratorTest {
    @Test
    void testExecuteLinear() {
        Map<String,List<String>> wf = Map.of("A", List.of("B"), "B", List.of("C"));
        String rep = new WorkflowOrchestrator().execute(wf, "A");
        assertTrue(rep.contains("Start:A"));
        assertTrue(rep.contains("Complete:C"));
    }
}
