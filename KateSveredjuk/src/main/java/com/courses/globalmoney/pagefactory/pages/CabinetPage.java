package com.courses.globalmoney.pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CabinetPage extends BasePage {

    @FindBy(css = ".ch_user")
    private WebElement userMenu;

    @FindBy(className = "ch_user_info")
    private WebElement userInfo;

    @FindBy(css = "ul.ch_user_menu li:nth-child(2)")
    private WebElement logOutItem;


    public CabinetPage(WebDriver driver) {
        super(driver);
    }

    public String getUserId() {
        return userInfo.getText();
    }

    private void openUserMenu() {
        userMenu.click();
    }

    public void logOut() {
        openUserMenu();
        logOutItem.click();
    }
}
