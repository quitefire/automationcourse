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
    private String email;

    @Test(dataProvider = "testData", priority = 1, groups = "registration_db_cleanup")
    public void testRegistrationSuccessful(Credential credential) throws Exception {
        email = credential.getEmail();
        expected = new ArrayList<>();
        expected.add(DataUtils.getMessage("msg01"));
        expected.add(DataUtils.getMessage("msg02") + credential.getFirstName() + DataUtils.getMessage("msg03") +
                credential.getLastName() + DataUtils.getMessage("msg04"));

        UserControlPanelPage userControlPanelPage = (UserControlPanelPage) new HomePage(driver)
                .clickOnLogin()
                .clickRegisterButton()
                .setRegistrationCredentials(credential.getFirstName(), credential.getLastName(), credential.getEmail(),
                        credential.getPassword(), credential.getPasswordConfirmation())
                .submitRegistration(true);

        Assert.assertEquals(userControlPanelPage.getActualMessages(), expected);
    }

    @Test(dataProvider = "testData", priority = 2, groups = "registration_db_cleanup")
    public void testRegistrationExistingUser(Credential credential) throws Exception {
        expected = new ArrayList<>();
        expected.add(DataUtils.getMessage("msg05"));
        RegistrationPage registrationPage = (RegistrationPage) new HomePage(driver)
                .clickOnLogin()
                .clickRegisterButton()
                .setRegistrationCredentials(credential.getFirstName(), credential.getLastName(), credential.getEmail(),
                        credential.getPassword(), credential.getPasswordConfirmation())
                .submitRegistration(false);

        Assert.assertEquals(registrationPage.getActualMessages(), expected);

    }

    @DataProvider(name = "testData")
    public Iterator<Object[]> getCredentials() {
        return DataUtils.getRegistrationCredentials();
    }

    @AfterGroups("registration_db_cleanup")
    public void deleteTestUserFromDb(){
        //delete registered user
        driver.get("https://stolkacha.com.ua/pages/deleteuser.php?email=" + email);
        System.out.println(driver.findElement(By.tagName("body")).getText());
    }
}
