package automation.hotline;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by dtv on 05.06.2017.
 */
public class HomePage extends BasePage {

    private static final String HOME_PAGE_URL = "http://hotline.ua";
    By searchBox = By.id("searchbox");
    By doSearch = By.id("doSearch");

    public HomePage(WebDriver driver) {
        super(driver);
        driver.get(HOME_PAGE_URL);
    }

    public HomePage fillSearchField(String searchValue){

        driver.findElement(searchBox).sendKeys(searchValue);
        return this;
    }

    public SearchResultPage getSearchResult (){
        driver.findElement(doSearch).click();
        //getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#filters > div.cell.group-gr-185.full-list > div > div:nth-child(1) > a")));
        return new SearchResultPage(driver);
    }



}
