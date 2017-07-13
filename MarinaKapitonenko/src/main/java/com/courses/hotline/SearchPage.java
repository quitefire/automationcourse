package com.courses.hotline;

import com.courses.hotline.elements.Driver;
import com.courses.hotline.elements.TreeMenuBox;

public class SearchPage {

	public static String getUrl(){
		return "/sr/";
	}

	public static boolean isAt() {
		String currentUrl = Driver.getInstance().getCurrentUrl();
		return currentUrl.contains(getUrl());
	}

	public static void selectCategory(String url) {
		TreeMenuBox.click(url);
	}
}
