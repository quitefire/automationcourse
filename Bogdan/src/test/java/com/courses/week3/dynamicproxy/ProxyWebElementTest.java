package com.courses.week3.dynamicproxy;

import com.courses.week3.conciseapi.wrappers.WebDriverProvider;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ProxyWebElementTest {

    private ConciseAPI browser;

    @Before
    public void setUp() {
        WebDriverProvider.setupDriver();
        browser = new ConciseAPI();
    }

    @Test
    public void testFirstResultShouldContainText() {

        String expected = "Selenide: concise UI tests in Java";

        browser.open("http://google.com/ncr");
        browser.$(By.name("q")).sendKeys("selenide", Keys.ENTER);
        String actual = browser.$("#rso > div > div > div:nth-child(1) > div > div > h3").getText();

        Assert.assertEquals(expected, actual);
    }

    @After
    public void tearDown() throws Exception {
        WebDriverProvider.cleanUp();
    }
}
