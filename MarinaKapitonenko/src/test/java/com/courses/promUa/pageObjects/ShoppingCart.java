package com.courses.promUa.pageObjects;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ShoppingCart {

	public void close(){

		$(".x-overlay").find("[data-qaid=\"close_btn\"]").click();
	}

	public ElementsCollection getProducts(){
		return $$("[data-qaid=product_item]");
	}

	public void createOrder() {
		ElementsCollection order = $$("[data-qaid=\"create_order_btn\"]");
		order.first().click();
		$("h4.x-title").shouldHave(text("Оформление заказа"));
	}
}
