package com.courses.promUa;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.courses.promUa.pages.HomePage;
import com.courses.promUa.pages.Menu;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import java.math.BigDecimal;
import java.util.Comparator;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PromUaTest {

	@BeforeClass
	public static void setUp() {
		ChromeDriverManager.getInstance().setup();
		browser = "chrome";
		baseUrl = "https://prom.ua";
	}

	@Parameters({"username", "email", "password"})
	@Test(enabled = false)
	public void testRegistration(@Optional String username, @Optional String email, @Optional String password) {
		open("/");

		SelenideElement parentDiv = $$(".x-header__auth-item").get(1);

		parentDiv.find("[data-qaid=reg_element]")
				.scrollTo().click();
		parentDiv.find("[data-qaid=reg_as_buyer_btn]").parent().click();

		Faker fake = new Faker();

		if (username == null) {
			username = fake.name().username();
		}

		if (email == null) {
			email = fake.internet().emailAddress();
		}

		if (password == null) {
			password = fake.internet().password();
		}

		$("[data-qaid=\"name\"]").setValue(username);
		$("[data-qaid=\"email\"]").setValue(email);
		$("[data-qaid=\"password\"]").setValue(password);
		$("[data-qaid=\"submit\"]").click();

		$("[data-extend=\"DynamicHeader\"]").shouldBe(visible);
	}

	@Test(enabled = false)
	public void testLogin() {
		open("/");
		$("[data-bazooka=\"DynamicHeader\"]").shouldBe(visible);

		$("[data-qaid=\"auth_element\"]").click();

		$("#phone_email").setValue("juchka.sirko@gmail.com");
		$("#password").setValue("juchka.sirko@");
		$("#submit_login_button").click();


		$("[data-extend=\"DynamicHeader\"]").shouldBe(visible);

		open("/");

		SelenideElement menu = $("x-categories-menu__list x-categories-menu__list_type_fake");
		menu.find("a[href=\"/Voentorg\"]").scrollTo().hover().find("a[href=\"/Odezhda-i-obuv\"]");

	}

	@Test(enabled = true)
	public void testNavigateToTelniashka() {
		open("/");

		SelenideElement menu = $("[data-qaid=\"categories_menu\"]");
		menu.hover();

		SelenideElement cat = menu.find(".x-categories-menu__wrapper");
		cat.find("[data-qaid=\"scroll_button\"]").click();

		cat.find("a[href=\"/Voentorg\"]").hover();
		cat.find("a[href=\"/Odezhda-i-obuv\"]").hover();
		cat.find("a[href=\"/Telnyashki\"]").click();

	}

	@Test(enabled = true)
	public void testSelectHighTelniashka() {
		open("/Telnyashki");

		$$(".x-filters").filterBy(text("Диапазон цен")).first().findAll(".x-filters-checkbox__text").last().click();
		$("a[data-qaid=\"-price\"]").click();

		ElementsCollection products = $$("[data-qaid=product_block]");
		//ElementsCollection prices = $$("div[data-qaid=\"price\"] > span");
		//products.filterBy(text("Тельняшка"));


		SelenideElement max = products.stream()
				.filter(
						p -> p.find("span[itemprop=\"name\"]").getText().startsWith("Тельняшка")
				)
				.max(Comparator.comparing(p -> new BigDecimal(
						p.find(("div[data-qaid=\"price\"] > span")).getText().replace(",", ".")
				))).get();

		max.find(".x-gallery-tile__content").scrollTo().hover();
		max.find(".x-gallery-tile__extra").find("[data-qaid=\"buy-button\"]").click();

		$(".x-overlay").find("[data-qaid=\"close_btn\"]");

	}

	@Test(enabled = false)
	public void testSelectLowTelniashka() {
		open("/Telnyashki");

		$$(".x-filters").filterBy(text("Диапазон цен")).first().find(".x-filters-checkbox__text").click();
		$("a[data-qaid=\"price\"]").click();

		SelenideElement prod = $("[itemscope=\"itemscope\"]");
		prod.find(".x-gallery-tile__content").hover();
		prod.find(".x-gallery-tile__extra").find("[data-qaid=\"buy-button\"]").click();

		$(".x-overlay").find("[data-qaid=\"close_btn\"]").click();



	}

	@Test(enabled = true)
	public void testCart() {
		open("/Telnyashki");
		$("a[data-qaid=\"-price\"]").click();
		ElementsCollection products = $$("[itemscope=\"itemscope\"]");
		//SelenideElement prod = $("[itemscope=\"itemscope\"]");
		SelenideElement prod = products.first();
		prod.find(".x-gallery-tile__content").hover();
		prod.find(".x-gallery-tile__extra").find("[data-qaid=\"buy-button\"]").click();

		$(".x-overlay").find("[data-qaid=\"close_btn\"]").click();

		SelenideElement next = products.get(6).scrollTo();
		next.find(".x-gallery-tile__content").hover();
		next.find(".x-gallery-tile__extra").find("[data-qaid=\"buy-button\"]").click();

		ElementsCollection order = $$("[data-qaid=\"create_order_btn\"]");



		order.first().click();
		$("h4.x-title").shouldHave(text("Оформление заказа"));
		back();

		if (order.size() > 1){
			order.get(1).click();
			$("h4.x-title").shouldHave(text("Оформление заказа"));
		}
	}

	@Test(enabled = true)
	public void testScenario() {
		HomePage homePage = new HomePage();
		homePage.open();

		Menu menu = new Menu();
		menu.category("Военторг")
				.subCategory("Одежда и обувь")
				.subCategory("Тельняшки")
				.select()
				.click();
	}
}
