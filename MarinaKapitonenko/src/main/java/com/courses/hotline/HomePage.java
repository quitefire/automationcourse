package com.courses.hotline;


import com.courses.hotline.elements.Driver;
import com.courses.hotline.elements.SearchBox;

public class HomePage {

	public static void goTo(){
		Driver.getInstance().get("http://hotline.ua");
	}

	public static void searchFor(String queryString) {
		SearchBox searchBox = new SearchBox();
		searchBox.search(queryString);
	}


}