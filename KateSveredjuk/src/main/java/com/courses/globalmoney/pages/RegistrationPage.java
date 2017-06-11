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

    @FindBy(className = "m_input_accept disabled")
    public WebElement submitButton;

    public void chooseRadioButtonEmail() {
        radioButtonEmail.click();
    }

    public void chooseRadioButtonPhone() {
        radioButtonPhone.click();
    }

    public void setEmail(String email) {
        inputEmailorPhone.sendKeys(email);
    }

    public void setPhone(int phone) {
        inputEmailorPhone.sendKeys(String.valueOf(phone));
    }

    public void setFirstPassword(String firstPassword) {
        inputFirstPassword.sendKeys(firstPassword);
    }

    public void setSecondPassword(String secondPassword) {
        inputSecondPassword.sendKeys(secondPassword);
    }

    public void registrationByEmail(String email, String firstPassword, String secondPassword) {
        chooseRadioButtonEmail();
        setEmail(email);
        setFirstPassword(firstPassword);
        setSecondPassword(secondPassword);
        submitButton.submit();
    }

    public void registrationByPhone(Integer phone,String firstPassword, String secondPassword){
        chooseRadioButtonPhone();
        setPhone(phone);
        setFirstPassword(firstPassword);
        setSecondPassword(secondPassword);
        submitButton.submit();
    }

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

}
