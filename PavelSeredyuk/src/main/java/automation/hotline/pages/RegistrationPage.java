package automation.hotline.pages;


import com.sun.javafx.css.StyleCache;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static automation.hotline.constants.CoreConstants.errorText;

public class RegistrationPage extends BasePage {

    private By userEmail = By.name("email");
    private By userNick = By.name("nick");
    private By userPassword = By.name("password");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }


    public RegistrationPage fillUserEmailField(String email, String nick, String password) {

        driver.findElement(userEmail).sendKeys(email, Keys.ENTER);
        driver.findElement(userNick).sendKeys(nick, Keys.ENTER);
        driver.findElement(userPassword).sendKeys(password);
        driver.findElement(By.id("submit-button")).click();
        return this;
    }

    public boolean isRegistrationSuccess() {

        WebElement successRegistration = driver.findElement(By.cssSelector("div.cell7.cell-768.cell6-980 > h1"));
        if (successRegistration != null) return true;
        return false;
    }

    public List<String> errorArray() {
        List<String> errorArray = new ArrayList<>();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_email")));
            errorArray.add(errorText);
        } catch (TimeoutException e) {
            errorArray.add("");
        }
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_nick")));
            errorArray.add(errorText);
        } catch (TimeoutException e) {
            errorArray.add("");
        }
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_password")));
            errorArray.add(errorText);
        } catch (TimeoutException e) {
            errorArray.add("");
        }

        return errorArray;
    }

}
