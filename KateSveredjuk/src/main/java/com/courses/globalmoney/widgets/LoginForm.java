package com.courses.globalmoney.widgets;

import com.courses.globalmoney.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginForm extends BasePage {

    public LoginForm(WebDriver driver) {
        super(driver);
    }

    public LoginForm setUsername(String username) {
        driver.findElement(By.name("j_username")).sendKeys(username);
        return this;
    }

    public LoginForm setPassword(String password) {
        driver.findElement(By.name("j_password")).sendKeys(password);
        return this;
    }

    public void submit() { //
        driver.findElement(By.cssSelector("button[type='submit']")).submit();
    }

    public String getValidationMessage() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".m_success_title")))
                .getText();
    }

}


