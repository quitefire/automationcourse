package com.courses.hotlineFinal.core;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowSwitcher {

	public static WebDriver getHandleToWindow(String title, WebDriver driver){

		WebDriver popup = null;
		Set<String> windowIterator = driver.getWindowHandles();
		System.err.println("No of windows :  " + windowIterator.size());
		for (String s : windowIterator) {
			popup = driver.switchTo().window(s);
			if (popup.getTitle().equals(title) ){
				return popup;
			}
		}
		return popup;
	}

}
