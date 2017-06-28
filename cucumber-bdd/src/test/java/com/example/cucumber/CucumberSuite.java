package com.example.cucumber;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static com.codeborne.selenide.Configuration.*;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "com.example.cucumber.steps",
        tags = {"@regression"},
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json", "ru.yandex.qatools.allure.cucumberjvm.AllureReporter",
        }
)
public class CucumberSuite {

    @BeforeClass
    public static void setUp() {
        ChromeDriverManager.getInstance().setup();
        browser = "chrome";
        baseUrl = "http://hotline.ua";
        startMaximized = true;
    }
}
