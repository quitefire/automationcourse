package com;

import com.courses.hotline.fixtures.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.net.URL;

public class UploadScreenshotTest extends BaseTest {

    @Test
    public void testScreenshotIsUploaded() throws Exception {
        driver.get("http://hotline.ua/feedback/");
        WebElement uploadFileElement = driver.findElement(By.cssSelector("#feedback div.js-image input[name='images[]']"));
        File file = getFileFromResources("screenshot.png");
        uploadFileElement.sendKeys(file.getAbsolutePath());
    }

    //your screenshot fileName in the resources folder
    private File getFileFromResources(String fileName) {
        //ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        ClassLoader classLoader = getClass().getClassLoader();
        URL resourceURL = classLoader.getResource(fileName);
        if (resourceURL == null) {
            throw new RuntimeException("Can't find such file in classpath !!!");
        }
        return new File(resourceURL.getFile());
    }
}
