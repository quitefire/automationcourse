package com.courses.week3.customconditions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomConditions {

    public static ExpectedCondition<WebElement> visible(final WebElement element) {
        return input -> element.isDisplayed() ? element : null;
    }

    public static ExpectedCondition<Boolean> titleContainsWord(String wordToSearch) {
        return driver -> driver != null && driver.getTitle().contains(wordToSearch);
    }

    public static ExpectedCondition<Boolean> titleTextEquals(String expectedTitle) {
        return new TitleTextEqualsCondition(expectedTitle);
        //return driver -> driver != null && driver.getTitle().equals(expectedTitle);
    }


}

