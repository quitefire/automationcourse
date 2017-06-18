package com.courses.hotlineFinal.pages;

import com.courses.hotlineFinal.pages.filters.Filter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage extends BasePage{

	private Filter filter;

	private By products = By.cssSelector(".cell.gd .cell.gd-item");

	public SearchResultsPage(WebDriver driver) {
		super (driver);
	}

	public Filter getFilter() {
		return filter;
	}

	public SearchResultsPage filterBy(Filter.Category category, Filter.Option option) {
		closeBottomBar();
		filter = Filter.get(category, option, driver);
		filter.select();
		return this;
	}

	public List<WebElement> getResults(){
		return findAll(products);
	}

	public int getFilterCounter(){
		return filter.getCount();
	}

}
