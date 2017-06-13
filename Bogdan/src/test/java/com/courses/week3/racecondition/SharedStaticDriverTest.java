package com.courses.week3.racecondition;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SharedStaticDriverTest extends ThreadLocalBaseTest {

    @Test
    public void test1() throws Exception {

        String expectedText = "quality";

        getDriver().get("http://google.com/ncr");
        WebElement searchField = getDriver().findElement(By.name("q"));
        searchField.sendKeys(expectedText);
        String actualText = searchField.getText();

        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void test2() throws Exception {

        String expectedText = "automation";

        getDriver().get("http://google.com/ncr");
        WebElement searchField = getDriver().findElement(By.name("q"));
        searchField.sendKeys(expectedText);
        String actualText = searchField.getText();

        Assert.assertEquals(expectedText, actualText);
    }


}