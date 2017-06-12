package com.courses.globalmoney;

import com.courses.globalmoney.data.RegistrationData;
import com.courses.globalmoney.fixtures.BaseTest;
import com.courses.globalmoney.pages.GMMainPage;
import com.courses.globalmoney.pages.RegistrationPage;
import org.junit.Test;

public class RegistrationTest extends BaseTest {

    @Test
    public void testSuccessfulRegistrationWithEmail() throws Exception {
        RegistrationData registrationData = RegistrationData.validEmail;

        // 1) 1st version
        new GMMainPage(driver)
                .open()
                .openRegistrationForm().
                registrationByEmail(registrationData.getEmail(), registrationData.getFirstPassword(), registrationData.getSecondPassword());


/*       2) more verbose style without methods chaining;
        GMMainPage gmMainPage = new GMMainPage(driver);
        RegistrationPage registrationPage = gmMainPage
                .open()
                .openRegistrationForm();
        registrationPage.
                registrationByEmail(registrationData.getEmail(), registrationData.getFirstPassword(), registrationData.getSecondPassword());*/

        //TODO: add assertion that verifying that the user has been successfully registered
    }
}