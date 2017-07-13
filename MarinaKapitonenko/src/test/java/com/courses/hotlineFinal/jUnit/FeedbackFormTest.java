package com.courses.hotlineFinal.jUnit;


import com.courses.hotlineFinal.pages.FeedbackPage;
import com.courses.hotlineFinal.pages.HomePage;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class FeedbackFormTest extends BaseTest {

	@Category(TestTypes.RegressionTests.class)
	@Test
	public void navigateToFeedbackPage(){

		HomePage home = new HomePage(driver);
		home.open()
				.navigateTo("Обратная связь");

		FeedbackPage feedbackPage = new FeedbackPage(driver);

		assertThat(feedbackPage.isAt(), is(true));
	}

	@Category(TestTypes.SanityTests.class)
	@Test
	public void submitEmptyFeedbackForm() {

		FeedbackPage feedbackPage = new FeedbackPage(driver);

		((FeedbackPage)feedbackPage.open())
				.submitForm();

		assertThat(feedbackPage.hasValidationErrors(), is(true));
	}

	@Category(TestTypes.RegressionTests.class)
	@Test
	public void feedbackFormDropdown() {

		String subject = "Предложение по улучшению сайта";

		FeedbackPage feedbackPage = new FeedbackPage(driver);

		((FeedbackPage)feedbackPage.open())
				.selectSubject(subject);

		assertThat(feedbackPage.getSelectedSubject(), is(equalTo(subject)));
	}

	@Category(TestTypes.RegressionTests.class)
	@Test
	public void feedbackFormUploadImageFile() {


		FeedbackPage feedbackPage = new FeedbackPage(driver);

		((FeedbackPage)feedbackPage.open())
				.uploadFile("Desert.jpg");

		assertThat(feedbackPage.getFileInputs().size(), is(greaterThan(1)));

	}

	@Category(TestTypes.RegressionTests.class)
	@Test
	public void feedbackFormUploadNotImageFile() {


		FeedbackPage feedbackPage = new FeedbackPage(driver);

		((FeedbackPage)feedbackPage.open())
				.uploadFile("text.txt");

		assertThat(feedbackPage.fileInputGetInvalidTypeErrorMessage(), is(notNullValue()));

	}

}
