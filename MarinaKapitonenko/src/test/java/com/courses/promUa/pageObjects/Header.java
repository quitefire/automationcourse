package com.courses.promUa.pageObjects;

import com.codeborne.selenide.SelenideElement;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Header {

	SelenideElement userBox = $$(".x-header__auth-item").get(1);

	public SelenideElement getRegisterAsBtn(RegistrationPage.UserType userType){
		SelenideElement btn = null;
		switch (userType){
			case COMPANY:
				throw new NotImplementedException();
			case CUSTOMER:
				userBox.find("[data-qaid=reg_element]")
						.scrollTo().click();
				btn = userBox.find("[data-qaid=reg_as_buyer_btn]").parent();
		}
		return btn;
	}

	public void checkUserIsLoggedIn(){
		$("[data-extend=\"DynamicHeader\"]").shouldBe(visible);
	}

	public SelenideElement getHomeBtn(){
		return $(".x-header__logo");
	}
}
