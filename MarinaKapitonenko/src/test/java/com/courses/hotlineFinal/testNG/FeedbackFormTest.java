package com.courses.hotlineFinal.testNG;

import com.courses.hotlineFinal.core.ConciseAPI;
import com.courses.hotlineFinal.core.DriverFactory;
import com.courses.hotlineFinal.pages.FeedbackPage;
import com.courses.hotlineFinal.pages.HomePage;
import com.github.javafaker.Faker;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.stqa.selenium.factory.WebDriverPool;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class FeedbackFormTest{

	private WebDriver driver;

	@AfterClass
	public static void tearDown(){
		WebDriverPool.DEFAULT.dismissAll();
	}


	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser){
		driver = DriverFactory.getDriver(browser);
	}

	@Test
	public void navigateToFeedbackPage(){

		HomePage home = new HomePage(driver);
		home.open()
				.navigateTo("Обратная связь");

		FeedbackPage feedbackPage = new FeedbackPage(driver);

		assertThat(feedbackPage.isAt(), is(true));
	}

	@Test
	public void submitEmptyFeedbackForm() {

		FeedbackPage feedbackPage = new FeedbackPage(driver);

		((FeedbackPage)feedbackPage.open())
				.submitForm();

		assertThat(feedbackPage.hasValidationErrors(), is(true));
	}

	@Test
	public void feedbackFormDropdown() {

		String subject = "Предложение по улучшению сайта";

		FeedbackPage feedbackPage = new FeedbackPage(driver);

		((FeedbackPage)feedbackPage.open())
				.selectSubject(subject);

		assertThat(feedbackPage.getSelectedSubject(), is(equalTo(subject)));
	}


	@Test
	public void feedbackFormUploadImageFile() {


		FeedbackPage feedbackPage = new FeedbackPage(driver);

		((FeedbackPage)feedbackPage.open())
				.uploadFile("Desert.jpg");

		assertThat(feedbackPage.getFileInputs().size(), is(greaterThan(1)));

	}

	@Test
	public void feedbackFormUploadNotImageFile() {


		FeedbackPage feedbackPage = new FeedbackPage(driver);

		((FeedbackPage)feedbackPage.open())
				.uploadFile("text.txt");

		assertThat(feedbackPage.fileInputGetInvalidTypeErrorMessage(), is(notNullValue()));

	}

}
