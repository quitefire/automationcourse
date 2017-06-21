package automation.hotline.pages;


import com.sun.javafx.css.StyleCache;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

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

    public String[] errorArray() {
        String[] errorArray = new String[3];

        WebElement errorEmail = driver.findElement(By.id("error_email"));
        errorArray[0] = errorEmail == null ? "" : errorEmail.getText();

        WebElement errorNick = driver.findElement(By.id("error_nick"));
        errorArray[1] = errorNick == null ? "" : errorNick.getText();

        WebElement errorPassword = driver.findElement(By.id("error_password"));
        errorArray[2] = errorPassword == null ? "" : errorPassword.getText();

        return errorArray;
    }

}
