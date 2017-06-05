package ua.com.stolkachaTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.*;
import ua.com.stolkacha.pages.HomePage;
import ua.com.stolkacha.pages.LoginPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by Serhii Babenko on 6/2/2017.
 */
public class TestLoginButtonTitle {
    private WebDriver driver;
//    private static Wait<WebDriver> wait;

    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "E:\\Courses\\automationcourse\\BabenkoSergey\\resources\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void testLoginButtonTitle() throws Exception {
        String expected = "Войти";
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickOnLogin();
        Assert.assertEquals(expected, loginPage.getLoginButtonTitle());
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.close();
    }

//    @DataProvider(name = "Name")
//    public static Object[][] Name() {
//
//    }


}
