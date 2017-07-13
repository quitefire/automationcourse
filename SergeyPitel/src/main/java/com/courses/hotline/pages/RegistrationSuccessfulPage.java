package com.courses.hotline.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationSuccessfulPage extends BasePage {

    @FindBy(css = ".title-24")
    private WebElement successMessage;

    public RegistrationSuccessfulPage(WebDriver driver) {
        super(driver);
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}
