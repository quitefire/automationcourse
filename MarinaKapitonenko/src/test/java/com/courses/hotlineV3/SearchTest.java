package com.courses.hotlineV3;

import com.courses.hotlineV3.pages.filters.Filter;
import com.courses.hotlineV3.pages.filters.PriceFilter;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

	@Test
	public void searchForIphoneFilterByPrice() {

		app.openHomePage()
				.searchFor("iphone")
				.filterBy(Filter.Category.PRICE, PriceFilter.PriceOption.UAH_2500_3500)
				.seeResultsCountMatchFilterCount()
				.seeResultsMatchFilter();
	}


}