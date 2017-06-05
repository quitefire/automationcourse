package com.courses.hotline;

import com.courses.hotline.elements.Driver;
import com.courses.hotline.elements.Filter;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SearchTest {


	@BeforeClass
	public static void setUp() {
		Driver.init(Driver.CHROME);
	}

	@Test
	public void searchForIphoneFilterByPrice(){
		//  1) Search for "iphone" on http://hotline.ua
		HomePage.goTo();
		HomePage.searchFor("iphone");
		Assert.assertTrue(SearchPage.isAt());

		SearchPage.selectCategory(MobileAndSmartphonesPage.getUrl());
		Assert.assertTrue(MobileAndSmartphonesPage.isAt());

		// 2) Filter the found result by price ( filter by "Цена" attribute).
		Filter filter = Filter.PRICE_3500_5000;
		int count = MobileAndSmartphonesPage.getFilterCount(filter);

		MobileAndSmartphonesPage.filterBy(filter);
		//3) Check that all the filtered results' prices are within the price range you selected
		// (e.g  price range - between 3500 and 5000 uah, check that each result price are between 3500 and 5000 uah)

		Assert.assertTrue(MobileAndSmartphonesPage.areResultsMatchPriceFilter(filter));

		// 4) OPTIONAL: check that number of results are the same as numbers shown next to price range
		// ( e.g.   3500 - 5000 uah (4)) ->  you need to check that number of the filtered results is 4)
		String expectedSubheading = "Выбрано " + count + " моделей: " + filter.getText();
		String actualSubheading = MobileAndSmartphonesPage.getSubheading();

		Assert.assertEquals(expectedSubheading, actualSubheading);
		Assert.assertEquals(count, MobileAndSmartphonesPage.getResultsCount());

	}

	@AfterClass
	public static void tearDown() throws Exception {
		Driver.quit();
	}

}