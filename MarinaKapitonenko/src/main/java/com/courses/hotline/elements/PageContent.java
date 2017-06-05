package com.courses.hotline.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageContent {

	public static String getSubheading(){
		return Driver.getInstance().findElement(By.tagName("h2")).getText();
	}

	public static int getResultsCount() {
		return getResults().size();
	}

	public static boolean areResultsMatchPriceFilter(Filter filterName) {
		return getResults().stream().allMatch(element -> isWithinPriceRange(element, filterName));
	}

	private static List<WebElement> getResults(){
		return Driver.getInstance().findElements(By.cssSelector(".cell.gd .cell.gd-item"));
	}

	private static boolean isWithinPriceRange(WebElement element, Filter filterName){
		String value = element.findElement(By.cssSelector(".text-14.text-12-640>b")).getText();
		value = value.replaceAll("\\s","");
		int price = Integer.valueOf(value.substring(0, value.indexOf("-")));
		return price >= filterName.getLow() && price <= filterName.getHigh() ;
	}


}