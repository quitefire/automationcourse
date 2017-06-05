package com.courses.hotline.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class FilterBox {

	private static String id = "filters";

	public static void select(Filter filterName) {

		String value = filterName.getText();
		WebElement link = Driver.getInstance().findElement(By.linkText(value));
		JavascriptExecutor executor = (JavascriptExecutor)Driver.getInstance();
		executor.executeScript("arguments[0].click()", link);
	}

	public static int getFilterCount(Filter filterName) {
		String value = filterName.getText();
		String count = Driver.getInstance().findElement(By.linkText(value)).findElement(By.xpath("..")).getText();

		return Integer.valueOf(count.substring(count.indexOf("(") + 1, count.indexOf(")")));
	}
}