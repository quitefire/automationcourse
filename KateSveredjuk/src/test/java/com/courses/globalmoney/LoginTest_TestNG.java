package com.courses.globalmoney;

import com.courses.globalmoney.data.UserData;
import com.courses.globalmoney.fixtures.BaseTest_TestNG;
import com.courses.globalmoney.pages.CabinetPage;
import com.courses.globalmoney.pages.GMMainPage;
import com.courses.globalmoney.utils.SiteConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest_TestNG extends BaseTest_TestNG {

    private GMMainPage mainPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        mainPage = new GMMainPage(driver);
        mainPage.open();
    }

    @DataProvider(name = "validData")
    public Object[][] validData() {
        return new Object[][]{
                {"380633699425", "12345679", "91687567485143"},
                {"91687567485143", "12345679", "91687567485143"}
        };

    }

    @DataProvider(name = "invalidData")
    public Object[][] invalidData() {
        return new Object[][]{
                {"+380633699425", "12345679" },
                {"0633699425", "12345679"}

        };
    }

    @DataProvider(name="emptyData")
    public Object [] [] emptyData(){
        return new Object[][]{
                {"","1234567"},
                {"380633699425",""},
                {"91687567485143",""},
                {""," "}
        };
    }
    @Test (dataProvider = "validData",groups = "validData")
    public void testLoginWithValidCredentials(String login,String password, String id) {

        mainPage.loginForm.logIn(login, password);


        CabinetPage cabinetPage = new CabinetPage(driver);
        String actualUserId = cabinetPage.getUserId();
        String cabinetPageUrl = cabinetPage.getUrl();

        cabinetPage.logOut();


        Assert.assertEquals(id, actualUserId);
        Assert.assertEquals(SiteConstants.CABINET_PAGE_URL, cabinetPageUrl);

    }


    @Test (dataProvider = "invalidData",groups = "invalidData")
    public void testLoginWithInvalidCredentials(String login, String password) {

        String expectedMessage = "Ошибка авторизации: Server error";

        mainPage.loginForm.logIn(login, password);
        String actualValidationMessage = mainPage.loginForm.erorMassege.getText();


        System.out.println(actualValidationMessage);

        Assert.assertEquals(expectedMessage, actualValidationMessage);
        Assert.assertEquals(SiteConstants.SITE_URL, mainPage.getUrl());
    }

    @Test(dataProvider = "emptyData",groups ="emptyData" )
    public void testLoginWithEmptyCredentials(String login, String password) {

        mainPage.loginForm.logIn(login, password);
        Assert.assertFalse(mainPage.loginForm.submitButton.isEnabled());
    }

}
