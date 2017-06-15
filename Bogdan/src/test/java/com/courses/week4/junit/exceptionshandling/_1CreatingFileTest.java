package com.courses.week4.junit.exceptionshandling;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class _1CreatingFileTest {

    @Test
    public void testCreateTempFile() throws IOException {

        //creating a temporary directory
        Path tmpDir = Files.createTempDirectory("tmp");
        // deteling the created above directory
        tmpDir.toFile().delete();
        // creating a file in the deleted directory , will throw NoSuchFileException
        Path tmpFile = Files.createTempFile(tmpDir, "test", ".txt");
    }
}