package com.courses.hotlineV3;

import com.courses.hotlineV3.application.ApplicationManager;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
	protected ApplicationManager app;
	protected Faker faker;

	@BeforeMethod
	public void setUp(){
		app = new ApplicationManager();
		faker = new Faker();
	}

	@AfterSuite
	public void tearDown(){
		app.close();
	}

}