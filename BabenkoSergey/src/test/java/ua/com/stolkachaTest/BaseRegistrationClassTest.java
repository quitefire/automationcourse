package ua.com.stolkachaTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;

/**
 * Created by Serhii Babenko on 6/7/2017.
 */
public class BaseRegistrationClassTest {
    protected WebDriver driver;


    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "E:\\Courses\\automationcourse\\BabenkoSergey\\src\\main\\resources\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.close();
    }
}
