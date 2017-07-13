package com.courses.hotlineV2.pages.filters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class Filter {

	protected int count;
	protected WebDriver driver;
	protected Option option;

	public Filter(WebDriver driver, Option option) {
		this.driver = driver;
		this.option = validOption(option);
		PageFactory.initElements(driver, this);
	}

	public static Filter get(Category category, Option option, WebDriver driver) {
		Filter filter = null;
		switch (category){
			case PRICE: filter = new PriceFilter(driver, option);
			break;
		}
		return filter;
	}

	public void select(){
		String value = option.getText();
		WebElement link = driver.findElement(By.linkText(value));
		saveCount(link);
		link.click();
	}


	protected void saveCount(WebElement element) {
		String count = element.findElement(By.xpath("..")).getText();
		this.count = Integer.valueOf(count.substring(count.indexOf("(") + 1, count.indexOf(")")));
	}

	public int getCount() {
		return count;
	}
	
	public abstract boolean match(WebElement element);
	protected abstract Option validOption(Option option);

	public enum Category {
		PRICE;
	}

	public interface Option {
		String getText();
	}
}
