package com.courses.week3.customconditions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class TitleTextEqualsCondition implements ExpectedCondition<Boolean> {

    private final String expectedTitle;

    public TitleTextEqualsCondition(String expectedTitle) {
        this.expectedTitle = expectedTitle;
    }

    @Override
    public Boolean apply(WebDriver driver) {
        return driver.getTitle().equals(expectedTitle);
    }
}