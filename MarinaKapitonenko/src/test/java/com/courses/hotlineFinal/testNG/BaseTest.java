package com.courses.hotlineFinal.testNG;


import com.courses.hotlineFinal.core.ConciseAPI;
import com.courses.hotlineFinal.core.DriverFactory;
import com.courses.week3.conciseapi.utils.ScreenshotUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import ru.stqa.selenium.factory.WebDriverPool;

public abstract class BaseTest extends ConciseAPI {
	WebDriver driver;
	Faker faker;


	@BeforeMethod
	public void setUp(){
		driver = DriverFactory.getDriver(null);
		faker = new Faker();
	}

	@AfterMethod
	public void saveScreenshot(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtils.takeScreenshot(driver);
		}
	}

	@AfterSuite
	public static void tearDown(){
		WebDriverPool.DEFAULT.dismissAll();
	}

	@Override
	public WebDriver getWebDriver() {
		return driver;
	}

}