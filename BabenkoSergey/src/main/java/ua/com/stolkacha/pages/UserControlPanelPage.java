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
public class UserControlPanelPage extends BasePage {
    private WebElement registrationMessageField;
    private WebElement welcomeMessageField;

    public UserControlPanelPage(WebDriver driver) {
        super(driver);
    }

    public String getSuccessfulRegistrationText() {
        registrationMessageField = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".messages .success-msg")));
        return registrationMessageField.getText();
    }

    public String getWelcomeMessage() {
        welcomeMessageField = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".welcome-msg")));
        return welcomeMessageField.getText();
    }

    public List<String> getActualMessages() {
        List<String> expected = new ArrayList<>();
        expected.add(getSuccessfulRegistrationText());
        expected.add(getWelcomeMessage());
        return expected;
    }
}
