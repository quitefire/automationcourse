package com.courses.globalmoney.fixtures;

import org.openqa.selenium.TakesScreenshot;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import javax.xml.crypto.Data;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class BaseTest_TestNG {

    protected static WebDriver driver;


    @BeforeMethod
    public static void setAll() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void TakeScreenshot(ITestResult result) throws Exception {

        if (result.getStatus() == ITestResult.FAILURE) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot,
                    new File("C:\\Users\\Катюша.Кот\\automationcourse\\KateSveredjuk\\src\\test\\java\\com\\courses\\globalmoney\\resources\\"
                            + result.getName()
                            + Arrays.toString(result.getParameters()) + ".png"));
        }
        driver.quit();
    }

//    @AfterClass
//    public static void tearDown() {
//      driver.quit();
//    }

}
