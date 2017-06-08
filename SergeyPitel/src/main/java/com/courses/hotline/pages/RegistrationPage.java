package com.courses.hotline.pages;


import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class RegistrationPage extends BasePage {

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "nick")
    private WebElement nicknameInput;

    @FindBy(id = "passw1")
    private WebElement passwordInput;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    @FindBy(id = "error_email")
    private WebElement emailFieldError;

    @FindBy(id = "error_nick")
    private WebElement nicknameFieldError;

    @FindBy(id = "error_password")
    private WebElement passwordFieldError;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    public RegistrationPage enterNickname(String nickname) {
        nicknameInput.clear();
        nicknameInput.sendKeys(nickname);
        return this;
    }

    public RegistrationPage enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public List<String> getInputErrorMessages() {
        List<String> errorMessages = new ArrayList<>();
        WebDriverWait shortWait = new WebDriverWait(driver, 3);
        try {
            shortWait.until(ExpectedConditions.visibilityOf(emailFieldError));
            errorMessages.add(emailFieldError.getText());
        } catch (TimeoutException e) {
            e.printStackTrace();
            errorMessages.add("");
        }

        try {
            errorMessages.add(shortWait.until(ExpectedConditions.visibilityOf(nicknameFieldError)).getText());
        } catch (TimeoutException e) {
            e.printStackTrace();
            errorMessages.add("");
        }

        try {
            shortWait.until(ExpectedConditions.visibilityOf(passwordFieldError));
            errorMessages.add(passwordFieldError.getText());
        } catch (TimeoutException e) {
            e.printStackTrace();
            errorMessages.add("");
        }
        return errorMessages;
    }
}

