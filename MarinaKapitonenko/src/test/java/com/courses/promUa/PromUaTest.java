package com.courses.promUa;

import com.courses.promUa.models.User;
import com.courses.promUa.pageObjects.*;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;


public class PromUaTest {

	@BeforeClass
	public static void setUp() {
		ChromeDriverManager.getInstance().setup();
		browser = "chrome";
		baseUrl = "https://prom.ua";
	}


	@Parameters({"username", "email", "password"})
	@Test(enabled = true)
	@Title("Заказ двух тельняшек")
	public void testScenario(@Optional String username, @Optional String email, @Optional String password) {

		HomePage homePage = new HomePage();
		Header header = new Header();
		RegistrationPage registration = new RegistrationPage();
		Menu menu = new Menu();
		CategoryPage categoryPage = new CategoryPage("Тельняшка");
		ShoppingCart shoppingCart = new ShoppingCart();
		OrderPage orderPage = new OrderPage();

		Faker fake = new Faker();
		if (username == null) username = fake.name().username();
		if (email == null) email = fake.internet().emailAddress();
		if (password == null) password = fake.internet().password();

		homePage.open();
		header.getRegisterAsBtn(RegistrationPage.UserType.CUSTOMER).click();
		registration.registerAs(new User(username, email, password));
		header.checkUserIsLoggedIn();

		header.getHomeBtn().click();
		menu.category("Военторг")
				.subCategory("Одежда и обувь")
				.subCategory("Тельняшки")
				.select();

		categoryPage.bookCheapProduct();
		shoppingCart.close();

		categoryPage.resetFilters();
		categoryPage.bookExpensiveProduct();

		shoppingCart.getProducts().shouldHaveSize(2);
		shoppingCart.createOrder();

		orderPage.shouldBeDisplayed();

	}

	@Step("Перейти на потрал prom.ua")
	private void openHomePage(){}



}
