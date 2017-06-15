package com.courses.week3.conciseapi.pages;

import com.courses.week3.conciseapi.wrappers.ConciseAPI;
import org.openqa.selenium.By;

import static org.openqa.selenium.Keys.ENTER;

public class HotlineMainPage extends ConciseAPI {

    private By searchbox = By.id("searchbox");

    public HotlineResultPage searchFor(String text) {
        type(searchbox, text + ENTER);
        return new HotlineResultPage();
    }
}