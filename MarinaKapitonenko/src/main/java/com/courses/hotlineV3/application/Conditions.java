package com.courses.hotlineV3.application;

import com.courses.hotlineV3.pages.filters.Filter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Conditions {

    public static ExpectedCondition<List<WebElement>> listSizeIsAtLeast(final By listLocator, final int minimumSize){
        return driver -> {
            List<WebElement> list = driver.findElements(listLocator);
            return list.size() >= minimumSize ? list : null;
        };
    }

    public static ExpectedCondition<List<WebElement>> listSizeIsExactly(final By listLocator, final int size){
        return driver -> {
            List<WebElement> list = driver.findElements(listLocator);
            return list.size() == size ? list : null;
        };
    }

    public static ExpectedCondition<List<WebElement>> elementsMatchFilter(final By listLocator, final Filter filter){
        return driver -> {
            List<WebElement> list = driver.findElements(listLocator);
            boolean match = list.stream().allMatch(filter::match);
            return match ? list : null;
        };
    }

    public static ExpectedCondition<Boolean> containsText(By elementLocator, String containableText){
        return ExpectedConditions.textToBePresentInElementLocated(elementLocator, containableText);
    }

    public static ExpectedCondition<Boolean> valueOf(By elementLocator, String containableText){
        return ExpectedConditions.textToBePresentInElementValue(elementLocator, containableText);
    }

    public static ExpectedCondition<WebElement> visible(By elementLocator){
        return ExpectedConditions.visibilityOfElementLocated(elementLocator);
    }
}
