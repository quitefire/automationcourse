package com.courses.hotline;


import static com.courses.hotline.enums.PropertiesKeys.*;
import static com.courses.hotline.utils.ProjectConstants.TEST_DATA_PROPERTIES_PATH;
import static com.courses.hotline.utils.RegistrationUtil.*;

import com.courses.hotline.pages.HomePage;
import com.courses.hotline.pages.RegistrationPage;
import com.courses.hotline.pages.RegistrationSuccessfulPage;
import com.courses.hotline.utils.DataProviderUtil;
import com.courses.hotline.utils.ReadPropertiesUtil;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class RegistrationTest extends BaseTest {

    @Test
    public void testUserRegistrationIsSuccessful() {
        String expected = ReadPropertiesUtil.getProperty(
                REGISTRATION_SUCCESSFUL_MESSAGE_KEY.getKey(),
                TEST_DATA_PROPERTIES_PATH
        );

        HomePage homePage = new HomePage(driver);
        homePage.open();
        RegistrationPage registrationPage = homePage.register();
        registrationPage.enterEmail(generateEmail());
        registrationPage.enterNickname(generateNickname());
        registrationPage.enterPassword("pass123456");
        registrationPage.clickSubmit();
        RegistrationSuccessfulPage registrationSuccessfulPage = new RegistrationSuccessfulPage(driver);

        Assert.assertEquals(expected, registrationSuccessfulPage.getSuccessMessage());
    }

    @DataProvider
    public Object[][] getInvalidUserParameters() {
        return DataProviderUtil.getInvalidUserParameters();
    }

    @Test(dataProvider = "getInvalidUserParameters")
    public void testUserRegistrationWithInvalidParameters(
            String email, String nickname, String password, String emailErrorMsg, String nicknameErrorMsg,
            String passwordErrorMsg) {

        HomePage homePage = new HomePage(driver);
        homePage.open();
        RegistrationPage registrationPage = homePage.register();
        registrationPage.enterEmail(email);
        registrationPage.enterNickname(nickname);
        registrationPage.enterPassword(password);
        registrationPage.clickSubmit();

        List<String> expectedMessages = new ArrayList<>();
        expectedMessages.add(emailErrorMsg);
        expectedMessages.add(nicknameErrorMsg);
        expectedMessages.add(passwordErrorMsg);

        Assert.assertEquals(expectedMessages, registrationPage.getInputErrorMessages());
    }
}
