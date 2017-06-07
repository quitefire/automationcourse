package com.courses.week3.hotlinev1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static com.courses.week3.hotlinev1.utils.CoreConstants.SITE_URL;

public class HotlineMainPage extends BasePage {

    public HotlineMainPage(WebDriver driver) {
        super(driver);
    }

    public HotlineResultPage searchFor(String text) {
        driver.findElement(By.id("searchbox")).sendKeys(text, Keys.ENTER);
        return new HotlineResultPage(driver);
    }

    public HotlineMainPage openPage() {
        driver.get(SITE_URL);
        return this;
    }
}