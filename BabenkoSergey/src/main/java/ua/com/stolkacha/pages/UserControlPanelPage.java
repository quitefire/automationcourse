package ua.com.stolkacha.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Serhii Babenko on 6/2/2017.
 */
public class UserControlPanelPage extends BasePage {
    private WebElement registrationMessageField;
    private WebElement welcomeMessageField;

    public UserControlPanelPage(WebDriver driver) {
        super(driver);
    }

    public String getSuccessfulRegistrationText(){
//        getWait().until(ExpectedConditions.urlMatches("https://stolkacha.com.ua/index.php/customer/account/index/"));
//        registrationMessageField = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".messages .success-msg")));
        registrationMessageField = getDriver().findElement(By.cssSelector(".messages .success-msg"));
        return registrationMessageField.getText();
    }

    public String getWelcomeMessage(){
//        getWait().until(ExpectedConditions.urlMatches("https://stolkacha.com.ua/index.php/customer/account/index/"));
//        welcomeMessageField = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".welcome-msg")));
        welcomeMessageField = getDriver().findElement(By.cssSelector("welcome-msg"));
        return welcomeMessageField.getText();
    }
}
