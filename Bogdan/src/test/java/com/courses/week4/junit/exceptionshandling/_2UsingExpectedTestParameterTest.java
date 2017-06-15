package com.courses.week4.junit.exceptionshandling;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class _2UsingExpectedTestParameterTest {

/*
    pros:
            - don't provide a functionality to check an exception message
            - difficult to spot a line of code from where the exception has been thrown
    cons:
            - clean code
*/

    @Test(expected = IOException.class)
    public void testCreateTempFile() throws IOException {
        Path tmpDir = Files.createTempDirectory("tmp");
        tmpDir.toFile().delete();
        Path tmpFile = Files.createTempFile(tmpDir, "test", ".txt");
    }
}