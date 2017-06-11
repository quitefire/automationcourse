package com.courses.globalmoney.widgets;

import com.courses.globalmoney.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginForm extends BasePage {

    @FindBy(name= "j_username")
    public WebElement loginInput;

    @FindBy(name = "j_password")
    public WebElement passwordInput;

    @FindBy(css = ".hh_input[type=submit]")
    public WebElement submitButton;

    @FindBy(css = ".m_success_title")
    public WebElement erorMassege;

    public LoginForm(WebDriver driver) {
        super(driver);
    }

    private LoginForm setUsername(String username) {
        loginInput.sendKeys(username);
        return this;
    }

    private LoginForm setPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    private void submit() {
        submitButton.submit();
    }

    public void logIn(String username, String password) {
        setUsername(username);
        setPassword(password);
        submit();
    }

    public String getValidationMessage() {
        return erorMassege.getText();
    }

}


