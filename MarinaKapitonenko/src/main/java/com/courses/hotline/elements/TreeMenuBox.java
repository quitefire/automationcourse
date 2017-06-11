package com.courses.hotline.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TreeMenuBox {

	private static String selector = ".tree-menu-box";

	public static void click(String href) {
		WebElement menuBox = Driver.getInstance().findElement(By.cssSelector(selector));
		menuBox.findElement(By.cssSelector("a[href*=\"" + href + "\"]")).click();
	}
}