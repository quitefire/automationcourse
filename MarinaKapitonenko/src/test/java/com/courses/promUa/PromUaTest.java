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

	private HomePage homePage = new HomePage();
	private Header header = new Header();
	private RegistrationPage registration = new RegistrationPage();
	private Menu menu = new Menu();
	private CategoryPage categoryPage = new CategoryPage("Тельняшка");
	private ShoppingCart shoppingCart = new ShoppingCart();
	private OrderPage orderPage = new OrderPage();

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

		Faker fake = new Faker();
		if (username == null) username = fake.name().username();
		if (email == null) email = fake.internet().emailAddress();
		if (password == null) password = fake.internet().password();

		openHomePage();
		registerAsCustomer(username, email, password);
		navigateToTelnyashki();
		addCheap();
		addExpensive();
		checkOrderForm();
	}

	@Step("1. Перейти на потрал prom.ua")
	private void openHomePage(){
		homePage.open();
	}

	@Step("2. Пройти регистрацию как покупатель")
	private void registerAsCustomer(String username, String email, String password){
		header.getRegisterAsBtn(RegistrationPage.UserType.CUSTOMER).click();
		registration.registerAs(new User(username, email, password));
		header.checkUserIsLoggedIn();
	}

	@Step("3.1. Перейти в Военторг / Одежда и обувь / Тельняшки")
	private void navigateToTelnyashki(){
		header.getHomeBtn().click();
		menu.category("Военторг")
				.subCategory("Одежда и обувь")
				.subCategory("Тельняшки")
				.select();
	}

	@Step("3.2. Добавить в корзину самую дешевую тельняшку")
	private void addCheap(){
		categoryPage.bookCheapProduct();
		shoppingCart.close();
	}

	@Step("3.3. Добавить в корзину самую дорогую тельняшку")
	private void addExpensive(){
		categoryPage.resetFilters();
		categoryPage.bookExpensiveProduct();
	}

	@Step("4. Проверить открытие форм оформления заказов")
	private void checkOrderForm(){
		shoppingCart.getProducts().shouldHaveSize(2);
		shoppingCart.createOrder();
		orderPage.shouldBeDisplayed();
	}
}
