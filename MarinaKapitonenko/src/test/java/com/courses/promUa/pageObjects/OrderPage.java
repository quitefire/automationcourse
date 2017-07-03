package com.courses.promUa.pageObjects;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class OrderPage {
	public void shouldBeDisplayed(){
		$("h4.x-title").shouldHave(text("Оформление заказа"));
	}
}
