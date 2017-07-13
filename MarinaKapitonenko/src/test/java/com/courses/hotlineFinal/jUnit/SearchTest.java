package com.courses.hotlineFinal.jUnit;


import com.courses.hotlineFinal.pages.HomePage;
import com.courses.hotlineFinal.pages.SearchResultsPage;
import com.courses.hotlineFinal.pages.filters.Filter;
import com.courses.hotlineFinal.pages.filters.PriceFilter;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SearchTest extends BaseTest {

	@Category(TestTypes.RegressionTests.class)
	@Test
	public void searchWithFilterByPrice() {

		HomePage home = new HomePage(driver);
		SearchResultsPage resultsPage = home.open()
				.searchFor("iphone");

		resultsPage.filterBy(Filter.Category.PRICE, PriceFilter.PriceOption.UAH_2500_3500);

		assertThat(resultsPage.getResults().size(), is(equalTo(resultsPage.getFilterCounter())));
		assertThat(resultsPage.getResults().stream().allMatch(resultsPage.getFilter()::match), is(true));

	}



}