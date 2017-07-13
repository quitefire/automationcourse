package com.courses.hotlineFinal.jUnit;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(TestTypes.SanityTests.class)
@Categories.ExcludeCategory(TestTypes.RegressionTests.class)
@Suite.SuiteClasses( {
		SearchTest.class,
		SignUpTest.class,
		FeedbackFormTest.class
})

public class SanityTestSuite {
	// should run:
	//      submitEmptyFeedbackForm()
	//      signUpWithInvalidEmail()
}
