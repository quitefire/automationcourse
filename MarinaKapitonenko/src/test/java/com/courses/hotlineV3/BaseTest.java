package com.courses.hotlineV3;

import com.courses.hotlineV3.application.ApplicationManager;
import com.github.javafaker.Faker;
import org.junit.AfterClass;
import org.junit.Before;


public abstract class BaseTest {
	protected static ApplicationManager app;
	protected Faker faker;

	@Before
	public void setUp(){
		app = new ApplicationManager();
		faker = new Faker();
	}

	@AfterClass
	public static void tearDown(){
		app.close();
	}

}