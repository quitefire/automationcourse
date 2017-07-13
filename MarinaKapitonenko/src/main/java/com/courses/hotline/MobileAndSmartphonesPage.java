package com.courses.hotline;

import com.courses.hotline.elements.Driver;
import com.courses.hotline.elements.Filter;
import com.courses.hotline.elements.FilterBox;
import com.courses.hotline.elements.PageContent;

public class MobileAndSmartphonesPage {

	public static String getUrl(){
		return "/mobile/mobilnye-telefony-i-smartfony/";
	}

	public static boolean isAt() {
		String currentUrl = Driver.getInstance().getCurrentUrl();
		return currentUrl.contains(getUrl());
	}

	public static void filterBy(Filter filterName) {
		FilterBox.select(filterName);
	}

	public static int getFilterCount(Filter filterName) {
		return FilterBox.getFilterCount(filterName);
	}

	public static String getSubheading(){
		return PageContent.getSubheading();
	}

	public static int getResultsCount() {
		return PageContent.getResultsCount();
	}

	public static boolean areResultsMatchPriceFilter(Filter filterName) {
		return PageContent.areResultsMatchPriceFilter(filterName);
	}
}