package ua.com.stolkachaTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ua.com.stolkacha.pages.HomePage;
import ua.com.stolkacha.pages.LoginPage;
import ua.com.stolkacha.pages.RegistrationPage;
import ua.com.stolkacha.pages.UserControlPanelPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Serhii Babenko on 6/2/2017.
 */
public class TestRegistrationSuccessful {
    private WebDriver driver;
    private static Wait<WebDriver> wait;
    private static List<String> expected;
    private static List<String> actual;


    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "E:\\Courses\\automationcourse\\BabenkoSergey\\resources\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        expected = new ArrayList<>();
        actual = new ArrayList<>();
    }
    @Test
    public void testRegistrationSuccessful() throws Exception {

        String firstName = "Serhii";
        String lastName = "Babenko";
        String expectedSuccessMessage = "Благодарим за регистрацию на нашем сайте .";
        String expectedWelcomeMessage = "Добро пожаловать, " + firstName + " " + lastName + "!";
        expected.add(expectedSuccessMessage);
        expected.add(expectedWelcomeMessage);

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickOnLogin();
        RegistrationPage registrationPage = loginPage.clickRegisterButton();
        registrationPage.setRegistrationCredentials("Serhii", "Babenko", "babenko.serhii89@gmail.com", "babenko25", "babenko25");
        UserControlPanelPage userControlPanelPage = registrationPage.submitRegistration();
        actual.add(userControlPanelPage.getSuccessfulRegistrationText());
        actual.add(userControlPanelPage.getWelcomeMessage());
        Assert.assertEquals(actual, expected);

    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.close();
    }
}
