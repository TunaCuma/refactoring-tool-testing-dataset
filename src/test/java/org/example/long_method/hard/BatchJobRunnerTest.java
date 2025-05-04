package org.example.long_method.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.nio.file.*;
import java.util.*;
import org.junit.jupiter.api.io.TempDir;  

class BatchJobRunnerTest {
    @Test
    void testRunAllSuccess(@TempDir Path tmpdir) throws Exception {  
        Path f = tmpdir.resolve("job.properties");
        Files.writeString(f, "id=J1\nsteps=step1,step2");  
        String res = new BatchJobRunner().runAll(List.of(f.toString()), 1);
        assertTrue(res.contains("Jobs Processed: 1"));
        assertTrue(res.contains("Failures: 0"));
    }
    
    @Test
    void testRunAllLoadFail() {
        String res = new BatchJobRunner().runAll(List.of("no-file"), 0);
        assertTrue(res.contains("Jobs Processed: 1"));
    }
}
