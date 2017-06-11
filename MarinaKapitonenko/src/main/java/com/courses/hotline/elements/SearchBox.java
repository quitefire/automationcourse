package com.courses.hotline.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchBox {

	private String selector = "#searchbox";

	public void search(String queryString) {
		WebElement searchBox = Driver.getInstance().findElement(By.cssSelector(selector));
		searchBox.sendKeys(queryString);
		searchBox.submit();
	}
}