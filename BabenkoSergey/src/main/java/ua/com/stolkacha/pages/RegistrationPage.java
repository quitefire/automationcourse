package ua.com.stolkacha.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ua.com.stolkacha.utils.DataUtils;
import ua.com.stolkacha.utils.MyProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Serhii Babenko on 6/2/2017.
 */
public class RegistrationPage extends BasePage implements RegistrationResult {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage setFirtName(String firtName) {
        getDriver().findElement(By.id("firstname")).sendKeys(firtName);
        return this;
    }

    public RegistrationPage setLastName(String lastname) {
        getDriver().findElement(By.id("lastname")).sendKeys(lastname);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        getDriver().findElement(By.id("email_address")).sendKeys(email);
        return this;
    }

    public RegistrationPage setPassword(String password) {
        getDriver().findElement(By.id("password")).sendKeys(password);
        return this;
    }

    public RegistrationPage setConfirmationPassword(String confirmation) {
        getDriver().findElement(By.id("confirmation")).sendKeys(confirmation);
        return this;
    }

    public UserControlPanelPage waitForUserControlPage(){
        getWait().until(ExpectedConditions.urlMatches(MyProperties.getProperty("user_control_panel_url")));
        return new UserControlPanelPage(getDriver());
    }

    public RegistrationPage waitForErrorMessage(){
        getWait().until(ExpectedConditions.visibilityOf(getDriver().findElement(By.cssSelector(".messages .error-msg"))));
        return this;
    }

    public void submitRegistration() {
        getDriver().findElement(By.id("form-validate")).submit();
    }

    public String getRegistrationErrorMessage() {
       return getDriver().findElement(By.cssSelector(".messages .error-msg")).getText();
    }

    public List<String> getErrorValidationMessages(){
        List<String> validationMessages = new ArrayList<>();
        getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        try {
            validationMessages.add(getDriver().findElement(By.id("advice-required-entry-firstname")).getText());
        }catch (NoSuchElementException e){
            validationMessages.add("");
        }
        try {
            validationMessages.add(getDriver().findElement(By.id("advice-required-entry-lastname")).getText());
        }catch (NoSuchElementException e){
            validationMessages.add("");
        }
        try {
            validationMessages.add(getDriver().findElement(By.id("advice-required-entry-email_address")).getText());
        }catch (NoSuchElementException e){
            validationMessages.add("");
        }
        try {
            validationMessages.add(getDriver().findElement(By.id("advice-required-entry-password")).getText());
        }catch (NoSuchElementException e){
            validationMessages.add("");
        }
        try {
            validationMessages.add(getDriver().findElement(By.id("advice-validate-cpassword-confirmation")).getText());
        }catch (NoSuchElementException e){
            validationMessages.add("");
        }
        try {
            validationMessages.add(getDriver().findElement(By.id("advice-required-entry-confirmation")).getText());
        }catch (NoSuchElementException e){
            validationMessages.add("");
        }

        return validationMessages;
    }

    public RegistrationPage setRegistrationCredentials(String firstName, String lastName, String email, String password, String passwordConfirmation) {
        setFirtName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
        setConfirmationPassword(passwordConfirmation);
        return this;
    }

    @Override
    public List<String> getActualMessages() {
        List<String> actualMessages = new ArrayList<>();
        actualMessages.add(getRegistrationErrorMessage());
        return actualMessages;
    }
}
