package com.courses.hotlineV2;

import com.courses.hotlineV2.application.ApplicationManager;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.Locale;

public abstract class BaseTest {
	protected ApplicationManager app;
	protected Faker faker;

	@BeforeMethod
	public void setUp(){
		app = new ApplicationManager();
		faker = new Faker();
	}

	@AfterMethod
	public void tearDown(){
		app.close();
		app = null;
		faker = null;
	}

}