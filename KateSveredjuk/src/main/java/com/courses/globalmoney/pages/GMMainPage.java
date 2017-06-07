package com.courses.globalmoney.pages;

import com.courses.globalmoney.utils.SiteConstants;
import org.openqa.selenium.WebDriver;

public class GMMainPage extends BasePage {

    private LoginForm loginForm;

    public GMMainPage(WebDriver driver) {
        super(driver);
        this.loginForm = new LoginForm(driver);
    }

    public void loginAs(String userName, String password) {
        loginForm.setUsername(userName).
                setPassword(password).
                submit();
    }

    public String getValidationMessage() {
        return loginForm.getValidationMessage();
    }

    public GMMainPage open() {
        driver.get(SiteConstants.SITE_URL);
        return this;
    }

}
