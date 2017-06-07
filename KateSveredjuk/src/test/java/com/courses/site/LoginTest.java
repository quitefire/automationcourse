package com.courses.site;


import com.courses.hotline.pages.BasePage;
import com.courses.hotline.pages.LoginPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * Created by Катюша on 06.06.2017
 */
public class LoginTest extends BasePage {
    private String usernameTrue = "380633699425";
    private String passwordTrue = "12345679";
    private String passwordFail = "12345679";

    public LoginTest(){
        super();
    }

    @Test
    public void testSuccsessEnter() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(usernameTrue, passwordTrue);

    }

    @AfterClass
    public static void tearDown() {
        getDriver().quit();
    }

}
