package com.courses.globalmoney;


import com.courses.globalmoney.data.UserData;
import com.courses.globalmoney.fixtures.BaseTest;
import com.courses.globalmoney.pages.CabinetPage;
import com.courses.globalmoney.pages.GMMainPage;
import com.courses.globalmoney.utils.SiteConstants;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest extends BaseTest {

    private GMMainPage mainPage;

    @Before
    public void setUp() {
        mainPage = new GMMainPage(driver);
        mainPage.open();
    }

    @Test
    public void testLoginWithValidCredentials() {

        UserData loginData = UserData.validData;

        mainPage.loginAs(loginData.getUserName(), loginData.getPassword());

        CabinetPage cabinetPage = new CabinetPage(driver);
        String actualUserId = cabinetPage.getUserId();
        String cabinetPageUrl = cabinetPage.getUrl();

        // cabinetPage.logOut();


        Assert.assertEquals(loginData.getUserId(), actualUserId);
        Assert.assertEquals(SiteConstants.CABINET_PAGE_URL, cabinetPageUrl);
    }


    @Test
    public void testLoginWithInvalidCredentials() {

        UserData loginData = UserData.invalidData;

        String expectedMessage = "Ошибка авторизации: Server error";

        mainPage.loginAs(loginData.getUserName(), loginData.getPassword());
        String actualValidationMessage = mainPage.getValidationMessage();


        System.out.println(actualValidationMessage);

        Assert.assertEquals(expectedMessage, actualValidationMessage);
        Assert.assertEquals(SiteConstants.SITE_URL, mainPage.getUrl());
    }

    @Test
    @Ignore
    public void testLoginWithEmptyCredentials() {
//
//        UserData loginData = new UserData("", "", "");
//
//        mainPage.loginAs(loginData.getUserName(), loginData.getPassword());
//        String actualValidationMessage = mainPage.getValidationMessage();
//
//        Assert.assertEquals(SiteConstants.SITE_URL, mainPage.getUrl());
    }

    @After
    public void cleanUp() throws Exception {
        ((ChromeDriver) driver).getSessionStorage().clear();
        // ((JavascriptExecutor) driver).executeScript("window.sessionStorage.removeItem('user')");
    }
}
