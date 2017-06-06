package com.courses.site;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {
    String url = "http://62.149.16.47:8080/";
    By userNameLocator = By.cssSelector("#j_username");
    By userPasswordLocator = By.cssSelector("#j_password");
    By loginButtonLocator = By.cssSelector("#submit");


    private WebDriver browser;

    public LoginPage(WebDriver browser) {
        this.browser = browser;
        if (!browser.getCurrentUrl().equals(url)) {
            throw new IllegalStateException("This is not the login page");
        }
    }

    public LoginPage typeUsername(String username) {
        browser.findElement(userNameLocator).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password){
        browser.findElement(userPasswordLocator).sendKeys(password);
        return this;
    }

    public LoginPage submitLogin(){
        browser.findElement(loginButtonLocator).submit();
        return new LoginPage(browser);
    }

    public LoginPage submitLoginExpactingFailure(){
        browser.findElement(loginButtonLocator).submit();
        return new LoginPage(browser);
    }

    public LoginPage login(String username, String password){
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }
}


