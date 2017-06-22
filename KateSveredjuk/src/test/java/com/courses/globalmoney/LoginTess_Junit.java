package com.courses.globalmoney;

import com.courses.globalmoney.data.UserData;
import com.courses.globalmoney.fixtures.BaseTest;
import com.courses.globalmoney.pages.CabinetPage;
import com.courses.globalmoney.pages.GMMainPage;
import com.courses.globalmoney.utils.SiteConstants;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(DataProviderRunner.class)
public class LoginTess_Junit extends BaseTest {
    private GMMainPage mainPage;
//    @Parameterized.Parameter(0)
//    public String login;
//    @Parameterized.Parameter(1)
//    public String password;
//    @Parameterized.Parameter(2)
//    public String id;

    @Before
    public void setUp() {
        mainPage = new GMMainPage(driver);
        mainPage.open();
    }

    @DataProvider
//    @Parameterized.Parameters (name = "ValidData {index}" )
    public static Object[][] providerValidData() {
        return new Object[][]{
                {"380633699425", "12345679", "91687567485143"},
                {"91687567485143", "12345679", "91687567485143"},
        };
    }

    @Test
    @UseDataProvider("providerValidData")
    public void testLoginWithValidCredentials(String login, String password, String id) {

        mainPage.loginForm.logIn(login, password);
        CabinetPage cabinetPage = new CabinetPage(driver);
        String actualUserId = cabinetPage.getUserId();
        String cabinetPageUrl = cabinetPage.getUrl();

        cabinetPage.logOut();

        Assert.assertEquals(id, actualUserId);
        Assert.assertEquals(SiteConstants.CABINET_PAGE_URL, cabinetPageUrl);
    }

    @DataProvider
    //  @Parameterized.Parameters (name = "Invalid Data {index}")
    public static Object[][] providerInValidData() {
        return new Object[][]{
                {"380633699425", "123456", ""},
                {"91687567485143", "12345", ""},
        };
    }

    @Test
    @UseDataProvider("providerInValidData")
    public void testLoginWithInvalidCredentials(String login, String password, String id) {

        String expectedMessage = "Ошибка авторизации: Server error";

        mainPage.loginForm.logIn(login, password);
        String actualValidationMessage = mainPage.loginForm.erorMassege.getText();


        System.out.println(actualValidationMessage);

        Assert.assertEquals(expectedMessage, actualValidationMessage);
        Assert.assertEquals(SiteConstants.SITE_URL, mainPage.getUrl());
    }

    @DataProvider
    public static Object[][] providerWithoutData() {
        return new Object[][]{
                {"380633699425", ""},
                {"", "12345679"},
        };
    }

    @Test
    @UseDataProvider("providerWithoutData")
    public void testLoginWithEmptyCredentials(String login, String password) {
        mainPage.loginForm.logIn(login, password);
        Assert.assertFalse(mainPage.loginForm.submitButton.isEnabled());
    }
}

