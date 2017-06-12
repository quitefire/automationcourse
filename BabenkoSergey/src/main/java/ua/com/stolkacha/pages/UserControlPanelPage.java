package ua.com.stolkacha.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Serhii Babenko on 6/2/2017.
 */
public class UserControlPanelPage extends BasePage implements RegistrationResult {

    public UserControlPanelPage(WebDriver driver) {
        super(driver);
    }

    public String getSuccessfulRegistrationText() {
       return getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".messages .success-msg"))).getText();
    }

    public String getWelcomeMessage() {
       return getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".welcome-msg"))).getText();
    }

    public List<String> getActualMessages() {
        List<String> actualMessages = new ArrayList<>();
        actualMessages.add(getSuccessfulRegistrationText());
        actualMessages.add(getWelcomeMessage());
        return actualMessages;
    }
}
