package com.courses.hotlineFinal.core;


import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import junitx.util.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.stqa.selenium.factory.WebDriverPool;

public class DriverFactory {

	public static WebDriver getDriver(){
		String browserName = PropertyManager.getProperty("BROWSER");
		WebDriver driver = null;
		switch (browserName){
			case "firefox":
				FirefoxDriverManager.getInstance().setup();
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();

//				FirefoxProfile profile = new FirefoxProfile();
//				profile.setPreference("security.insecure_field_warning.contextual.enabled", false);
//				profile.setPreference("security.insecure_password.ui.enabled", false);
//				capabilities.setCapability(FirefoxDriver.PROFILE, profile);

				driver = WebDriverPool.DEFAULT.getDriver(capabilities);
				break;
			default:
				ChromeDriverManager.getInstance().setup();
				driver = WebDriverPool.DEFAULT.getDriver(DesiredCapabilities.chrome());
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}
}
