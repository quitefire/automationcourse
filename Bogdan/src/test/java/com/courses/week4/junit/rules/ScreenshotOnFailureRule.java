package com.courses.week4.junit.rules;

import com.courses.week3.conciseapi.utils.ScreenshotUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;

public class ScreenshotOnFailureRule extends TestWatcher {
    private final WebDriver driver;

    public ScreenshotOnFailureRule(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    protected void failed(Throwable e, Description description) {
        ScreenshotUtils.takeScreenshot(driver);
    }
}
