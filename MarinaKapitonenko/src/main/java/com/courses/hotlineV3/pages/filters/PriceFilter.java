package com.courses.hotlineV3.pages.filters;

import com.courses.hotlineV3.application.Conditions;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PriceFilter extends Filter {

	private By priceBlock = By.cssSelector(".text-14.text-12-640>b");
	private By secondPriceLink = By.cssSelector(".blue-35a");

	public PriceFilter(WebDriver driver, Option option) {
		super(driver, option);
	}

	@Override
	public boolean match(WebElement element) {
		String valueNew = findOne(priceBlock).getText().replaceAll("\\s","");
		double priceNew = Double.valueOf(valueNew.substring(0, valueNew.indexOf("-")));
		boolean match = withinRange(priceNew);

		if (!match){
			assertThat(Conditions.listSizeIsAtLeast(secondPriceLink, 1));
			String valueSecond = findOne(secondPriceLink).getText().replaceAll("\\s","");
			double priceSecond = Double.valueOf(valueSecond);
			match = withinRange(priceSecond);
		}
		return match;
	}

	private boolean withinRange(double price) {
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

	public enum PriceOption implements Filter.Option {
		UAH_2500_3500("2500-3500 грн.", 2500, 3500),
		UAH_3500_5000("3500-5000 грн.", 3500, 5000),
		UAH_5000_7500("5000-7500 грн.", 5000, 7500);

		private String text;
		private int min;
		private int max;
		private String selector;

		PriceOption(String text, int min, int max) {
			this.text = text;
			this.min = min;
			this.max = max;
		}

		public String getText() {
			return text;
		}

		public int getMin() {
			return min;
		}

		public int getMax() {
			return max;
		}
	}

}
