package ua.com.stolkacha.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Serhii Babenko on 6/2/2017.
 */
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage typeUsername(String username) {
        getDriver().findElement(By.id("username")).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        getDriver().findElement(By.id("passwd")).sendKeys(password);
        return this;
    }

    public String getLoginButtonTitle(){
        return getDriver().findElement(By.id("send2")).getAttribute("title");
    }

    public RegistrationPage clickRegisterButton(){
        getDriver().findElement(By.cssSelector(".col-1.new-users .btn.btn-primary")).click();
        return new RegistrationPage(getDriver());
    }

}
