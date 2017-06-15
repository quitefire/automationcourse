package com.courses.week3.racecondition;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SharedStaticDriverTest extends StaticWebDriverBase {

    @Test
    public void test1() throws Exception {

        String expectedText = "quality";

        System.out.printf("Running test method  in test class=%s using thread = %s\n", getClass().getSimpleName(), Thread.currentThread().getId());

        getDriver().get("http://google.com/ncr");
        WebElement searchField = getDriver().findElement(By.name("q"));
        searchField.sendKeys(expectedText);
        String actualText = searchField.getAttribute("value");

        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void test2() throws Exception {
        System.out.printf("Running test method  in test class=%s using thread = %s\n", getClass().getSimpleName(), Thread.currentThread().getId());

        String expectedText = "automation";

        getDriver().get("http://google.com/ncr");
        WebElement searchField = getDriver().findElement(By.name("q"));
        searchField.sendKeys(expectedText);
        String actualText = searchField.getAttribute("value");

        Assert.assertEquals(expectedText, actualText);
    }


}