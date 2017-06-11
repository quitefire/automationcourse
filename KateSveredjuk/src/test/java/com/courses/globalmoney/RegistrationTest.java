package com.courses.globalmoney;

import com.courses.globalmoney.data.RegistrationData;
import com.courses.globalmoney.fixtures.BaseTest;
import com.courses.globalmoney.pagefactory.pages.GMMainPage;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Катюша on 11.06.2017
 */
public class RegistrationTest extends BaseTest {

    private GMMainPage mainPage;

    @BeforeClass

    public void SetUp(){
    mainPage = new GMMainPage(driver);
    mainPage.open();
    driver.findElement(By.cssSelector(".hh_register")).click();
    }

    @Test
    RegistrationData registrationData = RegistrationData.validEmail;
    mainPage.registrationPage.registrationByEmail(registrationData.getEmail(), registrationData.getFirstPassword(), registrationData.getSecondPassword()


