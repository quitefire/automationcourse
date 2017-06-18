package com.courses.hotlineFinal.jUnit;

import com.courses.hotlineFinal.core.ConciseAPI;
import com.courses.hotlineFinal.core.DriverFactory;
import com.github.javafaker.Faker;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import ru.stqa.selenium.factory.WebDriverPool;


public abstract class BaseTest extends ConciseAPI{
	WebDriver driver;
	Faker faker;


	@Before
	public void setUp(){
		driver = DriverFactory.getDriver();
		faker = new Faker();
	}

	@AfterClass
	public static void tearDown(){
		WebDriverPool.DEFAULT.dismissAll();
	}

	@Override
	public WebDriver getWebDriver() {
		return driver;
	}


}