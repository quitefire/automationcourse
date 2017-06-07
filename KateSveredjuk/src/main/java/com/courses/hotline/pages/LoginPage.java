package com.courses.hotline.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {
    private By userNameLocator = By.name("#j_username");
    private By userPasswordLocator = By.name("#j_password");
    private By loginButtonLocator = By.cssSelector("#submit");

    public LoginPage(WebDriver driver) {
        super();
    }

    private LoginPage typeUsername(String username) {
        getDriver().findElement(userNameLocator).sendKeys(username);
        return this;
    }

    private LoginPage typePassword(String password) {
        getDriver().findElement(userPasswordLocator).sendKeys(password);
        return this;
    }

    private LoginPage submitLogin() { //CabinetPage
        getDriver().findElement(loginButtonLocator).submit();
        return new LoginPage(getDriver()); //CabinetPage
    }

    public LoginPage login(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }
}


