package com.courses.hotlineV2.pages;

import com.courses.hotlineV2.application.NavigationHelper;
import com.courses.hotlineV2.pages.filters.Filter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends AnyPage {

	private Filter filter;

	@FindBy(css = "a.hide")
	private WebElement closeBottomBar;

	@FindBy(css = ".cell.gd .cell.gd-item")
	private List<WebElement> products;

	public SearchResultsPage(String url, WebDriver driver, NavigationHelper helper) {
		super(url, driver, helper);
	}


	public SearchResultsPage filterBy(Filter.Category category, Filter.Option option) {
		closeBottomBar.click();
		this.filter = Filter.get(category, option, driver);
		this.filter.select();
		return this;
	}

	public boolean resultsCountMatchFilterCount() {
		return (this.filter.getCount() == getResults().size());
	}

	public List<WebElement> getResults(){
		return products;
	}

	public boolean resultsMatchFilter() {
		return getResults().stream().allMatch(element -> this.filter.match(element));

	}


}
