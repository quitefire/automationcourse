package com.courses.hotline;


import com.courses.hotline.elements.Driver;
import com.courses.hotline.elements.SearchBox;
import com.courses.hotlineV3.application.NavigationHelper;
import org.openqa.selenium.WebDriver;

public class HomePage {


	public static void goTo(){
		Driver.getInstance().get("http://hotline.ua");
	}

	public static void searchFor(String queryString) {
		SearchBox searchBox = new SearchBox();
		searchBox.search(queryString);
	}


}