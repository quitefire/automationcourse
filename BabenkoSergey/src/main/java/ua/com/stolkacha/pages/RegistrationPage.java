package ua.com.stolkacha.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ua.com.stolkacha.utils.DataUtils;
import ua.com.stolkacha.utils.MyProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Serhii Babenko on 6/2/2017.
 */
public class RegistrationPage extends BasePage {
    private WebElement inputFirstName;
    private WebElement inputLastName;
    private WebElement inputEmail;
    private WebElement inputPassword;
    private WebElement inputPasswordConfirmation;
    private WebElement submitRegistrationButton;
    private WebElement registrationForm;
    private WebElement errorMessageField;
    private ExpectedCondition condition;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage setFirtName(String firtName) {
        inputFirstName = getDriver().findElement(By.id("firstname"));
        inputFirstName.sendKeys(firtName);
        return this;
    }

    public RegistrationPage setLastName(String lastname) {
        inputLastName = getDriver().findElement(By.id("lastname"));
        inputLastName.sendKeys(lastname);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        inputEmail = getDriver().findElement(By.id("email_address"));
        inputEmail.sendKeys(email);
        return this;
    }

    public RegistrationPage setPassword(String password) {
        inputPassword = getDriver().findElement(By.id("password"));
        inputPassword.sendKeys(password);
        return this;
    }

    public RegistrationPage setConfirmationPassword(String confirmation) {
        inputPasswordConfirmation = getDriver().findElement(By.id("confirmation"));
        inputPasswordConfirmation.sendKeys(confirmation);
        return this;
    }

    public UserControlPanelPage submitRegistrationSuccess() {
        registrationForm = getDriver().findElement(By.id("form-validate"));
        registrationForm.submit();
        getWait().until(ExpectedConditions.urlMatches(MyProperties.getProperty("user_control_panel_url")));
        return new UserControlPanelPage(getDriver());
    }

    public RegistrationPage submitRegistrationFail() {
        registrationForm = getDriver().findElement(By.id("form-validate"));
        registrationForm.submit();
        getWait().until(ExpectedConditions.visibilityOf(getDriver().findElement(By.cssSelector(".messages .error-msg"))));
        return this;
    }

    public String getRegistrationErrorMessage() {
        errorMessageField = getDriver().findElement(By.cssSelector(".messages .error-msg"));
        return errorMessageField.getText();
    }

    public RegistrationPage setRegistrationCredentials(String firstName, String lastName, String email, String password, String passwordConfirmation) {
        setFirtName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
        setConfirmationPassword(passwordConfirmation);
        return this;
    }

}
