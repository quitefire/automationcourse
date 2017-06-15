package com.courses.week4.junit.exceptionshandling;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;

public class _4UsingRuleTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    // notice that first you have to configure exception assertion and only then write code you wanna test
    @Test
    public void testCreateTempFile() throws IOException {
        Path tmpDir = Files.createTempDirectory("tmp");
        tmpDir.toFile().delete();
        thrown.expect(IOException.class);
        thrown.expectMessage(not(equalTo("")));
        Path tmpFile = Files.createTempFile(tmpDir, "test", ".txt");
        thrown = ExpectedException.none();
    }
}