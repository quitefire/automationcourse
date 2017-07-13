package ua.com.stolkachaTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import ua.com.stolkacha.domain.Credential;
import ua.com.stolkacha.pages.*;
import ua.com.stolkacha.utils.DataUtils;
import ua.com.stolkacha.utils.MyProperties;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Serhii Babenko on 6/2/2017.
 */
public class RegistrationTest extends BaseRegistrationClassTest {

    private static List<String> expected;
    private String email;

    @Test(dataProvider = "validTestData", priority = 1)
    public void testRegistrationSuccessful(Credential credential) throws Exception {
        email = credential.getEmail();
        expected = new ArrayList<>();
        expected.add(DataUtils.getMessage("msg01"));
        expected.add(DataUtils.getMessage("msg02") + credential.getFirstName() + DataUtils.getMessage("msg03") +
                credential.getLastName() + DataUtils.getMessage("msg04"));

        RegistrationPage registrationPage = (RegistrationPage) new HomePage(driver)
                .clickOnLogin()
                .clickRegisterButton()
                .setRegistrationCredentials(credential.getFirstName(), credential.getLastName(), credential.getEmail(),
                        credential.getPassword(), credential.getPasswordConfirmation());
                registrationPage.submitRegistration();
                UserControlPanelPage userControlPanelPage = registrationPage.waitForUserControlPage();
        Assert.assertEquals(userControlPanelPage.getActualMessages(), expected);
    }

    @Test(dataProvider = "validTestData", priority = 2, groups = "registration_db_cleanup")
    public void testRegistrationExistingUser(Credential credential) throws Exception {
        expected = new ArrayList<>();
        expected.add(DataUtils.getMessage("msg05"));
        RegistrationPage registrationPage = (RegistrationPage) new HomePage(driver)
                .clickOnLogin()
                .clickRegisterButton()
                .setRegistrationCredentials(credential.getFirstName(), credential.getLastName(), credential.getEmail(),
                        credential.getPassword(), credential.getPasswordConfirmation());
        registrationPage.submitRegistration();
        Assert.assertEquals(registrationPage.waitForErrorMessage().getActualMessages(), expected);
    }

    @Test(dataProvider = "testDataNotValid", priority = 3)
    public void testRegistrationWithNotValidData(Credential credential) throws Exception {

        expected = DataUtils.generateExpectedResult(credential);
        HomePage homePage = new HomePage(driver);

        RegistrationPage registrationPage = (RegistrationPage) new HomePage(driver)
                .clickOnLogin()
                .clickRegisterButton()
                .setRegistrationCredentials(credential.getFirstName(), credential.getLastName(), credential.getEmail(),
                        credential.getPassword(), credential.getPasswordConfirmation());
                registrationPage.submitRegistration();

        Assert.assertEquals(registrationPage.getErrorValidationMessages(), expected);

    }

    @DataProvider(name = "validTestData")
    public Iterator<Object[]> getCredentials() {
        return DataUtils.getRegistrationCredentials(MyProperties.getProperty("login_data_file_path"));
    }

    @DataProvider(name = "testDataNotValid")
    public Iterator<Object[]> getInvalidCredentials() {
        return DataUtils.getRegistrationCredentials(MyProperties.getProperty("invalid_registration_data"));
    }



    @AfterGroups("registration_db_cleanup")
    public void deleteTestUserFromDb(){
        //delete registered user
        driver.get("https://stolkacha.com.ua/pages/deleteuser.php?email=" + email);
        System.out.println(driver.findElement(By.tagName("body")).getText());
    }
}
