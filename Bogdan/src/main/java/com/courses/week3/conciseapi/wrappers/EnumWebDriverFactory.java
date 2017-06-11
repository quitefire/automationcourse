package com.courses.week3.conciseapi.wrappers;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public enum EnumWebDriverFactory {
    CHROME {
        @Override
        public WebDriver create() {
            ChromeDriverManager.getInstance().setup();
            return new ChromeDriver();
        }
    },
    IE {
        @Override
        public WebDriver create() {
            InternetExplorerDriverManager.getInstance().setup();
            return new InternetExplorerDriver();
        }
    };

    public abstract WebDriver create();
}