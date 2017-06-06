package com.courses.site;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by Катюша on 06.06.2017
 */
public class TestLoginPage extends BasePage {
    private String usernameTrue = "380633699425";
    private String passwordTrue = "12345679";
    private String passwordFail = "12345679";

    public String getUsernameTrue() {
        return usernameTrue;
    }

    public String getPasswordTrue() {
        return passwordTrue;
    }

    public String getPasswordFail() {
        return passwordFail;
    }

    @Test

    public void testSuccsessEnter() {
        LoginPage loginPage = new LoginPage(getBrowser());
        loginPage.login(usernameTrue, passwordTrue);

    }

    @AfterClass

    public static void tearDown() {
        getBrowser().quit();
    }

}
