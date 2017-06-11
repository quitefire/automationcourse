package com.courses.globalmoney.pages;

import com.courses.globalmoney.utils.SiteConstants;
import com.courses.globalmoney.widgets.LoginForm;
import org.openqa.selenium.WebDriver;

public class GMMainPage extends BasePage {

    public LoginForm loginForm;
    public RegistrationPage registrationPage;

    public GMMainPage(WebDriver driver) {
        super(driver);
        this.loginForm = new LoginForm(driver);
        registrationPage = new RegistrationPage(driver);
    }

    public GMMainPage open() {
        driver.get(SiteConstants.SITE_URL);
        return this;
    }

}
