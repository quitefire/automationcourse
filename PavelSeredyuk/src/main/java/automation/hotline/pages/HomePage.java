package automation.hotline.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static automation.hotline.constants.CoreConstants.SITE_URL;


/**
 * Created by dtv on 05.06.2017.
 */
public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(SITE_URL);
    }

    public RegistrationPage searchRegistrationPage(){
        driver.findElement(By.cssSelector(".login.in.abs.no-adapt-768 :nth-child(2)")).click();
        return new RegistrationPage(driver);
    }

    public SearchResultPage searchFor(String text) {
        driver.findElement(By.id("searchbox")).sendKeys(text, Keys.ENTER);
        return new SearchResultPage(driver);
    }
}
