package automation.hotline.pages;


import automation.hotline.model.RegistrationData;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.openqa.selenium.By.*;

public class RegistrationPage extends BasePage {

    private By userEmail = name("email");
    private By userNick = name("nick");
    private By userPassword = name("password");
    private By emailError = id("error_email");
    private By nickError = id("error_nick");
    private By passwordError = id("error_password");


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage registerAs(RegistrationData registrationData) {
        driver.findElement(userEmail).sendKeys(registrationData.getEmail());
        driver.findElement(userNick).sendKeys(registrationData.getNick());
        driver.findElement(userPassword).sendKeys(registrationData.getPassword());
        driver.findElement(id("submit-button")).submit();
        return this;
    }

    public List<String> getInputErrorMessages() {
        List<String> errorMessages = new ArrayList<>();

        for (By errorLocator : Arrays.asList(emailError, nickError, passwordError)) {
            try {
                String text = wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator)).getText();
                errorMessages.add(text);
            } catch (TimeoutException e) {
                errorMessages.add(StringUtils.EMPTY);
            }
        }
        return errorMessages;
    }
}
