package automation.hotline.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class RegistrationSuccess extends BasePage {

    public RegistrationSuccess(WebDriver driver) {
        super(driver);
    }

    public String checkSaccessRegitration(){
        WebElement regSaccessText =driver.findElement(By.cssSelector(".title-24.m_b-20"));

        return regSaccessText.getText();
    }
}
