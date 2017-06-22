package com.courses.globalmoney;

import com.courses.globalmoney.data.RegistrationData;
import com.courses.globalmoney.fixtures.BaseTest;
import com.courses.globalmoney.pages.GMMainPage;
import com.courses.globalmoney.pages.RegistrationPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Set;

public class RegistrationTest extends BaseTest {

    private GMMainPage mainPage;

    //    @BeforeClass
//    public void SetUp(){
//    mainPage = new GMMainPage(driver);
//    mainPage.open().openRegistrationForm();}
    @Test
    public void testSuccessfulRegistrationWithEmail() throws Exception {
        RegistrationData registrationData = RegistrationData.validEmail;
//         1) 1st version
        String originalWindow = driver.getWindowHandle();

        new GMMainPage(driver)
                .open()
                .openRegistrationForm().
                registrationByEmail(registrationData.getEmail(), registrationData.getFirstPassword(), registrationData.getSecondPassword());

        for (String childHandle : driver.getWindowHandles()) {
            if (!childHandle.equals(originalWindow)) {
                driver.switchTo().window(childHandle);
            }
        }

        String expected = "Код подтверждения отправленный";
        String actual = driver.findElement(By.cssSelector(".modal-dialog")).getText();
        Assert.assertEquals(expected, actual);

//      2) more verbose style without methods chaining;
        //       GMMainPage gmMainPage = new GMMainPage(driver);
        //      RegistrationPage registrationPage = gmMainPage
        //              .open()
        //               .openRegistrationForm();
        //      registrationPage.
        //              registrationByEmail(registrationData.getEmail(), registrationData.getFirstPassword(), registrationData.getSecondPassword());

        //TODO: add assertion that verifying that the user has been successfully registered
    }
}