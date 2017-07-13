package com.courses.hotlineV2.pages.filters;

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
