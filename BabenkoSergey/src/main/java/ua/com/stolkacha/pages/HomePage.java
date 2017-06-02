package ua.com.stolkacha.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Serhii Babenko on 6/2/2017.
 */
public class HomePage extends BasePage {

    private static final String HOME_PAGE_URL = "https://stolkacha.com.ua/";

    public HomePage(WebDriver driver) {
        super(driver);
        getDriver().get(HOME_PAGE_URL);
    }

    public LoginPage clickOnLogin(){
        getDriver().findElement(By.cssSelector(".quick-access .links .last a")).click();
        return new LoginPage(getDriver());
    }
}
