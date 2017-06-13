package com.courses.week4.junit.exceptionshandling;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class _3UsingTryCatchTest {

    //this approach overcomes all the previous cons , except it's not very handy to use try/catch and code looks bulky

    @Test
    public void testCreateTempFile() throws IOException {
        Path tmpDir = Files.createTempDirectory("tmp");
        tmpDir.toFile().delete();
        try {
            Path tmpFile = Files.createTempFile(tmpDir, "test", ".txt");
            Assert.fail("Expected IOException");
        } catch (IOException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }
}