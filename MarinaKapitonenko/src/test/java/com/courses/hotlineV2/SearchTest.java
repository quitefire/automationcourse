package com.courses.hotlineV2;

import com.courses.hotlineV2.pages.filters.Filter;
import com.courses.hotlineV2.pages.filters.PriceOption;
import com.courses.hotlineV2.pages.SearchResultsPage;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SearchTest extends BaseTest{

	@Test
	public void searchForIphoneFilterByPrice() {

		SearchResultsPage result = app.openHomePage()
				.searchFor("iphone")
				.filterBy(Filter.Category.PRICE, PriceOption.UAH_2500_3500);

				assertTrue(result.resultsCountMatchFilterCount());
				assertTrue(result.resultsMatchFilter());
	}


}