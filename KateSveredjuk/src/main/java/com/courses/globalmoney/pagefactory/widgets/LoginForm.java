package com.courses.globalmoney.pagefactory.widgets;

import com.courses.globalmoney.pagefactory.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginForm extends BasePage {

    @FindBy(name = "j_username")
    private WebElement userNameInput;

    @FindBy(name = "j_password")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    @FindBy(css = ".m_success_title")
    private WebElement validationMessage;

    public LoginForm(WebDriver driver) {
        super(driver);
    }

    public LoginForm setUsername(String username) {
        userNameInput.sendKeys(username);
        return this;
    }

    public LoginForm setPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public void submit() {
        submitButton.submit();
    }

    public String getValidationMessage() {
        return validationMessage.getText();
    }
}


