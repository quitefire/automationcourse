package com.courses.hotlineV3.pages;

import com.courses.hotlineV3.application.Conditions;
import com.courses.hotlineV3.application.NavigationHelper;
import com.courses.hotlineV3.pages.filters.Filter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends AnyPage {

	private Filter filter;


	private By products = By.cssSelector(".cell.gd .cell.gd-item");

	public SearchResultsPage(String url, WebDriver driver, NavigationHelper helper) {
		super(url, driver, helper);
	}

	public SearchResultsPage filterBy(Filter.Category category, Filter.Option option) {
		closeBottomBar();
		this.filter = Filter.get(category, option, driver);
		this.filter.select();
		return this;
	}

	private void closeBottomBar(){
		findOne("a.hide").click();
	}

	public SearchResultsPage seeResultsCountMatchFilterCount() {
		assertThat(Conditions.listSizeIsExactly(products, this.filter.getCount()));
		return this;
	}

	public SearchResultsPage seeResultsMatchFilter() {
		assertThat(Conditions.elementsMatchFilter(products, this.filter));
		return this;
	}


}
