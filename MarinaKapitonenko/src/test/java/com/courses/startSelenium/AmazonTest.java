package com.courses.startSelenium;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonTest {

	//browser and wait variables should be declared at a class level
	// so they can be seen(used) in all methods
	private static WebDriver browser;
	private static Wait<WebDriver> wait;

	/*  global precondition
	 this method runs BEFORE all the methods marked
	 with @Test annotation in your class
	 Usually, browser setup
	 and resource-consuming operations such as integration with internal services or db are done
	 */
	@BeforeClass
	public static void setUp() {
		//1) Specify the path to chrome driver
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		//2)Create the instance of concrete driver which is an abstraction over a browser
		browser = new ChromeDriver();
		//3)Create an instance of a "waiting" browser and pass our instance of browser to it ,
		// also specifying the maximum time we're willing to wait
		wait = new WebDriverWait(browser, 10);
		//4)Set browser configuration - make it start maximized
		browser.manage().window().maximize();
		browser.manage().deleteAllCookies();
    /*    for MacOS users - as a possible fix to an issue with maximizing :
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-fullscreen");
        browser = new ChromeDriver(chromeOptions);
    */
	}

	private static ChromeOptions setChromeOptions() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("start-fullscreen");
		return chromeOptions;
	}

	@Test
	public void testFirstSearchSuggestion() {
		//1) define the expected result
		String expectedSuggestion = "samsung galaxy s8 plus case";
		//2) navigate to the given url
		//more verbose option - browser.navigate().to("https://www.amazon.com");
		browser.get("https://www.amazon.com");
		//3) Find a webelement in the DOM using CSS selector
		WebElement searchElement = browser.findElement(By.cssSelector("#twotabsearchtextbox"));
		//4) Simulating typing into the search field
		searchElement.sendKeys("Samsung");
		//5) Defining a locator for the first suggestion web element
		// no searching for an element happening at the moment
		By firstSuggestionLocator = By.cssSelector("#issDiv0");
		//6) "Waiting" browser waits for firstSuggestionElement to be visible and returns
		// the element once the expected condition = true and time passed < time we set (10 seconds)
		WebElement firstSuggestionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(firstSuggestionLocator));
		//7) Getting the visible (i.e. not hidden by CSS) innerText of this element, including sub-elements,
		//without any leading or trailing whitespace.
		String firstSuggestionText = firstSuggestionElement.getText();
		//8) Finally, assert that expectedSuggestion equals to firstSuggestionText
		Assert.assertEquals(expectedSuggestion, firstSuggestionText);
	}


	/*  global postcondition
	  this method runs after all the methods marked
	  with @Test annotation in your class
	  */
	@AfterClass
	public static void tearDown() throws Exception {
		// kill the browser instance after each tests
		browser.quit();
	}
}