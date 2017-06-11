package com.courses.week3.racecondition;

import org.openqa.selenium.WebDriver;

public class StaticDriverBaseTest {

    protected WebDriver getDriver() {
        return StaticWebDriverRunner.getDriver();
    }
}
