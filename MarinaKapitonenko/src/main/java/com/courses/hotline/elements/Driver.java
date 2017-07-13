package com.courses.hotline.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

	public static final int FIREFOX = 1;
	public static final int CHROME = 2;

	private static WebDriver instance;

	public static WebDriver getInstance() {
		return instance;
	}

	private Driver() {
	}

	public static void init(int browser){

		if (browser == CHROME){
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			instance = new ChromeDriver();
		} else {
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			instance = new FirefoxDriver();
		}

		instance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		instance.manage().window().maximize();
		instance.manage().deleteAllCookies();
	}
	public static void quit(){
		instance.quit();
	}
}