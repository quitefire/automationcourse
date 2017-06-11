package com.courses.globalmoney.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CabinetPage extends BasePage {


    @FindBy(css = ".ch_user_info")
    public WebElement userId;

    @FindBy(css = ".ch_user")
    public WebElement userMenu;

    @FindBy(css ="ul.ch_user_menu li:nth-child(2)")
    public WebElement logOutButton;

    public CabinetPage(WebDriver driver) {
        super(driver);
    }

    public String getUserId() {
        return userId.getText();
    }

    private void openUserMenu() {
       userMenu.click();
    }

    public void logOut() {
        openUserMenu();
        logOutButton.click();
    }
}
