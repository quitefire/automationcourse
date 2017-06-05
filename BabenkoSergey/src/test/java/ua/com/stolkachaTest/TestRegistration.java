package ua.com.stolkachaTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.com.stolkacha.domain.Credential;
import ua.com.stolkacha.pages.HomePage;
import ua.com.stolkacha.pages.LoginPage;
import ua.com.stolkacha.pages.RegistrationPage;
import ua.com.stolkacha.pages.UserControlPanelPage;
import ua.com.stolkacha.utils.DataUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Serhii Babenko on 6/2/2017.
 */
public class TestRegistration {
    private WebDriver driver;
    private static Wait<WebDriver> wait;
    private static List<String> expected;
    private static List<String> actual;


    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "E:\\Courses\\automationcourse\\BabenkoSergey\\src\\main\\resources\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        expected = new ArrayList<>();
        actual = new ArrayList<>();
    }


    @Test(dataProvider = "testData")
    public void testRegistrationSuccessful(Credential credential) throws Exception {

        //String expectedSuccessMessage = "Благодарим за регистрацию на нашем сайте .";
        //String expectedWelcomeMessage = "Добро пожаловать, " + credential.getFirstName() + " " + credential.getLastName() + "!";

        expected.add(DataUtils.getMessage("msg01"));
        expected.add(DataUtils.getMessage("msg02") +credential.getFirstName()+DataUtils.getMessage("msg03")+
        credential.getLastName()+DataUtils.getMessage("msg04"));
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickOnLogin();

        RegistrationPage registrationPage = loginPage.clickRegisterButton();
        registrationPage.setRegistrationCredentials(credential.getFirstName(), credential.getLastName(), credential.getEmail(),
                credential.getPassword(), credential.getPasswordConfirmation());
        UserControlPanelPage userControlPanelPage = registrationPage.submitRegistration();
        actual.add(userControlPanelPage.getSuccessfulRegistrationText());
        actual.add(userControlPanelPage.getWelcomeMessage());
        Assert.assertEquals(actual, expected);

    }

    @Test(dataProvider = "testData")
    public void testRegistrationExistingUser(Credential credential) throws Exception {

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickOnLogin();
        RegistrationPage registrationPage = loginPage.clickRegisterButton();
        registrationPage.setRegistrationCredentials(credential.getFirstName(), credential.getLastName(), credential.getEmail(),
                credential.getPassword(), credential.getPasswordConfirmation());
        registrationPage.submitRegistration();

        Assert.assertEquals(registrationPage.getRegistrationErrorMessage(), DataUtils.getMessage("msg05"));

    }


    @DataProvider(name = "testData")
    public Iterator<Object[]> getCredentials() {
        System.out.println(DataUtils.getRegistrationCredentials());
        return DataUtils.getRegistrationCredentials();
    }



    @AfterMethod
    public void tearDown() throws Exception {
        driver.close();
    }
}
