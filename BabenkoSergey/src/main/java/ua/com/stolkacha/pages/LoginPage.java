package ua.com.stolkacha.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Serhii Babenko on 6/2/2017.
 */
public class LoginPage extends BasePage {
    By usernameLocator = By.id("username");
    By passwordLocator = By.id("passwd");
    By loginButtonLocator = By.id("send2");
    By registrationButtonLocator  = By.cssSelector(".col-1.new-users .btn.btn-primary");

    public LoginPage(WebDriver driver) {
        super(driver);

    }

    public LoginPage typeUsername(String username) {
        getDriver().findElement(usernameLocator).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        getDriver().findElement(passwordLocator).sendKeys(password);
        return this;
    }

    public String getLoginButtonTitle(){
        return getDriver().findElement(loginButtonLocator).getAttribute("title");
    }

    public RegistrationPage clickRegisterButton(){
        getDriver().findElement(registrationButtonLocator).click();
        return new RegistrationPage(getDriver());
    }

//    public HomePage submitLogin() {
//        webDriver.findElement(loginButtonLocator).submit();
//        return new HomePage(webDriver);
//    }
//
//    public LoginPage submitLoginExpectingFailure() {
//        webDriver.findElement(loginButtonLocator).submit();
//        return new LoginPage(driver);
//    }

//    public HomePage loginAs(String username, String password) {
//        typeUsername(username);
//        typePassword(password);
//        return submitLogin();
//    }
}
