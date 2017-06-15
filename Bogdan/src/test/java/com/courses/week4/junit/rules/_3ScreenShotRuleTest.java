package com.courses.week4.junit.rules;

import com.courses.week3.conciseapi.wrappers.WebDriverProvider;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.courses.week3.conciseapi.wrappers.WebDriverProvider.getDriver;

public class _3ScreenShotRuleTest {

    private static final String SITE_URL = "http://google.com/ncr";
    private By searchLocator = By.name("q");

    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverProvider.setupDriver();
    }

    @Rule
    public ScreenshotOnFailureRule thrown = new ScreenshotOnFailureRule(getDriver());

    @Test
    public void shouldNotTakeAScreenShot() {
        String expectedText = "quality";

        getDriver().get(SITE_URL);
        WebElement searchField = getDriver().findElement(searchLocator);
        searchField.sendKeys(expectedText);

        Assert.fail();
    }

    @Test
    public void shouldTakeAScreenShot() {
        String expectedText = "automation";

        getDriver().get(SITE_URL);

        WebElement searchField = getDriver().findElement(searchLocator);
        searchField.sendKeys(expectedText);
        String enteredText = searchField.getAttribute("value");
        Assert.assertEquals(expectedText, enteredText);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        WebDriverProvider.cleanUp();
    }
}
