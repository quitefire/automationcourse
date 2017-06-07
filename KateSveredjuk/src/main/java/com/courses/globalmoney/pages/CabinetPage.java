package com.courses.globalmoney.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CabinetPage extends BasePage {

    private By userMenu = By.cssSelector(".ch_user");


    public CabinetPage(WebDriver driver) {
        super(driver);
    }

    public String getUserId() {
        WebElement userInfoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ch_user_info")));
        return userInfoElement.getText();
    }

    private void openUserMenu() {
        driver.findElement(userMenu).click();
    }

    public void logOut() {
        openUserMenu();
        driver.findElement(By.cssSelector("ul.ch_user_menu li:nth-child(2)")).click();
    }
}
