package com.courses.hotlineV2.pages.filters;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PriceFilter extends Filter {

	@FindBy(css = ".text-14.text-12-640>b")
	private WebElement priceBlock;

	@FindBy(css = ".blue-35a")
	private WebElement secondPriceLink;

	@FindBy(css = ".blue-35a")
	private List<WebElement> secondPriceLinkList;

	public PriceFilter(WebDriver driver, Option option) {
		super(driver, option);
	}

	@Override
	public boolean match(WebElement element) {
		String valueNew = priceBlock.getText().replaceAll("\\s","");
		int priceNew = Integer.valueOf(valueNew.substring(0, valueNew.indexOf("-")));

		boolean match = withinRange(priceNew);

		if (!match && secondPriceLinkList.size() > 0){
			String valueSecond = secondPriceLink.getText().replaceAll("\\s","");
			int priceSecond = Integer.valueOf(valueSecond);
			match = withinRange(priceSecond);
		}
		return match;
	}

	private boolean withinRange(int price) {
		return  price >= ((PriceOption) this.option).getMin()
				&& price < ((PriceOption) this.option).getMax();
	}

	@Override
	protected Option validOption(Option option) {
		if (!(option instanceof PriceOption)) {
			throw  new InvalidArgumentException("PriceFilter accepts only PriceOption.");
		} else {
			return option;
		}
	}
}
