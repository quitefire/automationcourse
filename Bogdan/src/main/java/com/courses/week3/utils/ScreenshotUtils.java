package com.courses.week3.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public final class ScreenshotUtils {

    private ScreenshotUtils() {
    }

    public static void takeScreenshot(final WebDriver driver) {
        final File screenshot = ((TakesScreenshot) driver).
                getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("screenshots" + File.separator + "screen" + RandomStringUtils.randomNumeric(3) + ".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}