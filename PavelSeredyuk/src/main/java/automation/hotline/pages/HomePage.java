package automation.hotline.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static automation.hotline.utils.Configuration.HOME_PAGE_URL;

/**
 * Created by dtv on 05.06.2017.
 */
public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(HOME_PAGE_URL);
    }

    public SearchResultPage searchFor(String text) {
        driver.findElement(By.id("searchbox")).sendKeys(text, Keys.ENTER);
        return new SearchResultPage(driver);
    }
}
