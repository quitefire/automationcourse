package com.courses.promUa.pageObjects;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {


	public HomePage open() {
		Selenide.open("/");
		return this;
	}
}
