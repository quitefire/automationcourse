package ua.com.stolkachaTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.*;
import ua.com.stolkacha.domain.Credential;
import ua.com.stolkacha.pages.*;
import ua.com.stolkacha.utils.DataUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Serhii Babenko on 6/2/2017.
 */
public class RegistrationTest extends BaseRegistrationClassTest {

    private static List<String> expected;
    private static List<String> actual;
    private String email;

    @BeforeClass
    @Override
    public void setUp() throws Exception {
        super.setUp();
        expected = new ArrayList<>();
        actual = new ArrayList<>();
    }
    
    @Test(dataProvider = "testData", priority = 1)
    public void testRegistrationSuccessful(Credential credential) throws Exception {
        email = credential.getEmail();
        expected.add(DataUtils.getMessage("msg01"));
        expected.add(DataUtils.getMessage("msg02") + credential.getFirstName() + DataUtils.getMessage("msg03") +
                credential.getLastName() + DataUtils.getMessage("msg04"));

        UserControlPanelPage userControlPanelPage = new HomePage(driver)
                .clickOnLogin()
                .clickRegisterButton()
                .setRegistrationCredentials(credential.getFirstName(), credential.getLastName(), credential.getEmail(),
                        credential.getPassword(), credential.getPasswordConfirmation())
                .submitRegistrationSuccess();

        Assert.assertEquals(userControlPanelPage.getActualMessages(), expected);

    }

    @Test(dataProvider = "testData", priority = 2)
    public void testRegistrationExistingUser(Credential credential) throws Exception {

        RegistrationPage registrationPage = new HomePage(driver)
                .clickOnLogin()
                .clickRegisterButton()
                .setRegistrationCredentials(credential.getFirstName(), credential.getLastName(), credential.getEmail(),
                        credential.getPassword(), credential.getPasswordConfirmation())
                .submitRegistrationFail();

        Assert.assertEquals(registrationPage.getRegistrationErrorMessage(), DataUtils.getMessage("msg05"));

    }

    @DataProvider(name = "testData")
    public Iterator<Object[]> getCredentials() {
        System.out.println(DataUtils.getRegistrationCredentials());
        return DataUtils.getRegistrationCredentials();
    }


    @AfterClass
    @Override
    public void tearDown() throws Exception {
        //delete registered user
        driver.get("https://stolkacha.com.ua/pages/deleteuser.php?email=" + email);
        System.out.println(driver.findElement(By.tagName("body")).getText());
        super.tearDown();
    }
}
