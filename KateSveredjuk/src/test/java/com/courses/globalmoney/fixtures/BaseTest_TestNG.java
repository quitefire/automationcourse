package com.courses.globalmoney.fixtures;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.TakesScreenshot;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;


import javax.xml.crypto.Data;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class BaseTest_TestNG {

    protected static WebDriver driver;

    @Parameters({"browser"})
    @BeforeClass(alwaysRun = true)
    public void openBrowser(String browser) {
        try {
            if (browser.equalsIgnoreCase("Chrome")) {
                ChromeDriverManager.getInstance().setup();
                driver = new ChromeDriver();

            } else if (browser.equalsIgnoreCase("Firefox")) {
                FirefoxDriverManager.getInstance().setup();
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("IE")) {
                InternetExplorerDriverManager.getInstance().setup();
                driver = new InternetExplorerDriver();
            }
        } catch (WebDriverException e) {
            System.out.println(e.getMessage());
        }
    }
//    public static void setAll() {
//        ChromeDriverManager.getInstance().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//    }


    @AfterMethod
    public void TakeScreenshot(ITestResult result) throws Exception {

        if (result.getStatus() == ITestResult.FAILURE) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot,
                    new File("C:\\Users\\Катюша.Кот\\automationcourse\\KateSveredjuk\\src\\test\\java\\com\\courses\\globalmoney\\resources\\"
                            + result.getName()
                            + Arrays.toString(result.getParameters()) + ".png"));
        }

    }

    @AfterClass
    public static void tearDown() {
        if (driver != null)
            driver.quit();
    }

}
