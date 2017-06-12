package com.courses.junit.rules;

import com.google.common.io.Files;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.nio.charset.Charset;


public class _1TemporaryFolderTest {

    private static final Charset DEFAULT_CHARSET = Charset.defaultCharset();

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testDataWrittenToFile() throws Exception {
        String expectedText = "First line";
        File temporaryFile = folder.newFile();

        Files.write(expectedText, temporaryFile, DEFAULT_CHARSET);
        String actualText = Files.readFirstLine(temporaryFile, DEFAULT_CHARSET);

        Assert.assertEquals(expectedText, actualText);
    }
}
