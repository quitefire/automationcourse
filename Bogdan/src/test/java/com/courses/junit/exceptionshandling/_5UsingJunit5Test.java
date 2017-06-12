package com.courses.junit.exceptionshandling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;


public class _5UsingJunit5Test {

    @DisplayName("Testing exceptions with JUnit5 ")
    @Test
    void testCreateTempFile() throws IOException {
        Path tmpDir = Files.createTempDirectory("tmp");
        tmpDir.toFile().delete();

        Throwable thrown = assertThrows(IOException.class, () -> Files.createTempFile(tmpDir, "test", ".txt"));
        Assertions.assertAll((
                        () -> assertEquals(" expected message", thrown.getMessage())),
                () -> assertNotNull(thrown.getMessage()));
    }
}