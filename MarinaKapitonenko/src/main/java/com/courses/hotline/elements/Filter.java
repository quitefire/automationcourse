package com.courses.hotline.elements;

public enum Filter {
	PRICE_2500_3500("2500-3500 грн.", 2500, 3500),
	PRICE_3500_5000("3500-5000 грн.", 3500, 5000),
	PRICE_5000_7500("5000-7500 грн.", 5000, 7500);

	private String text;
	private int low;
	private int high;

	Filter(String text, int low, int high) {
		this.text = text;
		this.low = low;
		this.high = high;
	}

	public String getText() {
		return text;
	}

	public int getLow() {
		return low;
	}

	public int getHigh() {
		return high;
	}
}