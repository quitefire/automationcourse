package com.courses.globalmoney.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Катюша on 08.06.2017
 */
public class RegistrationPage extends BasePage {
    @FindBy(id = "registration_account_type_email")
    public WebElement radioButtonEmail;

    @FindBy(id = "registration_account_type_phone")
    public WebElement radioButtonPhone;

    @FindBy(name = "account")
    public WebElement inputEmailorPhone;

    @FindBy(id = "wallet_registration_password")
    public WebElement inputFirstPassword;

    @FindBy(name = "confirm_pass")
    public WebElement inputSecondPassword;

    @FindBy(name = "public_offer")
    public WebElement checkBoxPublicOffer;

    @FindBy(className = "m_input_accept")
    public WebElement submitButton;



    @FindBy(css = ".alert alert-danger")
    public WebElement massage;

    public String getMassage() {
        return massage.getText();
    }

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage chooseRadioButtonEmail() {
        if (!radioButtonEmail.isSelected()) radioButtonEmail.click();
        return this;
    }

    private RegistrationPage chooseRadioButtonPhone() {
        radioButtonPhone.click();
        return this;
    }

    private RegistrationPage setEmail(String email) {
        inputEmailorPhone.sendKeys(email);
        return this;
    }

    private RegistrationPage setPhoneNumber(String phoneNumber) {
        inputEmailorPhone.sendKeys(String.valueOf(phoneNumber));
        return this;
    }

    private RegistrationPage setFirstPassword(String password) {
        inputFirstPassword.sendKeys(password);
        return this;
    }

    private RegistrationPage setSecondPassword(String confirmPassword) {
        inputSecondPassword.sendKeys(confirmPassword);
        return this;
    }
    private RegistrationPage agreeWithOffer(){
        checkBoxPublicOffer.click();
        return this;
    }

    public void registrationByEmail(String email, String password, String confirmPassword) {
        chooseRadioButtonEmail().
                setEmail(email).
                setFirstPassword(password).
                setSecondPassword(confirmPassword).
                agreeWithOffer().
                submit();
    }

    public void registrationByPhone(String phone, String password, String confirmPassword) {
        chooseRadioButtonPhone().
                setPhoneNumber(phone).
                setFirstPassword(password).
                setSecondPassword(confirmPassword).
                agreeWithOffer().
                submit();
    }

    private void submit() {
        submitButton.submit();
    }
}
