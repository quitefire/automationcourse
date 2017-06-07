package com.courses.hotline.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegistrationPage extends BasePage {

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "nick")
    private WebElement nicknameInput;

    @FindBy(id = "passw1")
    private WebElement passwordInput;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage enterEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public RegistrationPage enterNickname(String nickname) {
        nicknameInput.sendKeys(nickname);
        return this;
    }

    public RegistrationPage enterPassword(String password) {
        emailInput.sendKeys(password);
        return this;
    }
}

