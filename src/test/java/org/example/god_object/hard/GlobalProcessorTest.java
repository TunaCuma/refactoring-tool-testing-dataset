package org.example.god_object.hard;

import org.junit.jupiter.api.Test; import static org.junit.jupiter.api.Assertions.*;
class GlobalProcessorTest {
    @Test
    void testComputeBuild() throws Exception {
        GlobalProcessor p = new GlobalProcessor(); p.ingest(1); p.ingest(2); p.computeStats(); p.buildSummary();
        assertTrue(p.isProcessed());
    }
    @Test
    void testExportNoException() throws Exception { GlobalProcessor p = new GlobalProcessor(); p.ingest(5); p.computeStats(); p.buildSummary(); assertDoesNotThrow(p::export); }
}
