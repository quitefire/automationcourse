package com.example.hotline;

import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.BeforeClass;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Configuration.*;

public class BaseTest {


    @BeforeClass
    public static void setUp() {
        ChromeDriverManager.getInstance().setup();
        browser = "chrome";
        baseUrl = "http://hotline.ua";
        startMaximized = true;
    }

    @After
    public void tearDown() throws IOException {
        screenshot();
    }

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File testResultScreenshot = Screenshots.takeScreenShotAsFile();
        return Files.toByteArray(testResultScreenshot);
    }

}