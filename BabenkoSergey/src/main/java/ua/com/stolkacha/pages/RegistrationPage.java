package ua.com.stolkacha.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
//    inputFirstName = getDriver().findElement(By.id("firstname"));
//    inputLastName = getDriver().findElement(By.id("lastname"));
//    inputPassword = getDriver().findElement(By.id("password"));
//    inputPasswordConfirmation = getDriver().findElement(By.id("confirmation"));

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    public RegistrationPage setFirtName(String firtName){
        inputFirstName = getDriver().findElement(By.id("firstname"));
        inputFirstName.sendKeys(firtName);
        return this;
    }
    public RegistrationPage setLastName(String lastname){
        inputLastName = getDriver().findElement(By.id("lastname"));
        inputLastName.sendKeys(lastname);
        return this;
    }
    public RegistrationPage setEmail(String email){
        inputEmail = getDriver().findElement(By.id("email_address"));
        inputEmail.sendKeys(email);
        return this;
    }
    public RegistrationPage setPassword(String password){
        inputPassword = getDriver().findElement(By.id("password"));
        inputPassword.sendKeys(password);
        return this;
    }
    public RegistrationPage setConfirmationPassword(String confirmation){
        inputPasswordConfirmation = getDriver().findElement(By.id("confirmation"));
        inputPasswordConfirmation.sendKeys(confirmation);
        return this;
    }

    public UserControlPanelPage submitRegistration(){
        registrationForm = getDriver().findElement(By.id("form-validate"));
        registrationForm.submit();
        getWait().until(ExpectedConditions.urlMatches("https://stolkacha.com.ua/index.php/customer/account/index/"));
        //submitRegistrationButton = getDriver().findElement(By.cssSelector(".buttons-set .button"));
       // submitRegistrationButton.click();
        return new UserControlPanelPage(getDriver());
    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param passwordConfirmation
     * @return
     */
    public RegistrationPage setRegistrationCredentials(String firstName, String lastName, String email, String password, String passwordConfirmation){
        setFirtName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
        setConfirmationPassword(passwordConfirmation);
                return this;
    }


}
