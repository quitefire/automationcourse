package com.courses.week3;

import com.courses.hotline.fixtures.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.net.URL;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WebDriverApiExampleTest extends BaseTest {


    //http://internetka.in.ua/selenium-webdriver-window/
    @Test
    public void testWindowHandles() throws Exception {

        driver.get("https://users.wix.com/signin");

        String originalWindow = driver.getWindowHandle();
        final Set<String> oldWindowsSet = driver.getWindowHandles();

        driver.findElement(By.cssSelector("button.signin-sozial-fazebook")).click();

        String newWindow = wait
                .until((ExpectedCondition<String>) driver -> {
                            Set<String> newWindowsSet = driver.getWindowHandles();
                            newWindowsSet.removeAll(oldWindowsSet);
                            return newWindowsSet.size() > 0 ?
                                    newWindowsSet.iterator().next() : null;
                        }
                );

        driver.switchTo().window(newWindow);

        System.out.println("New window title: " + driver.getTitle());
        driver.close();

        driver.switchTo().window(originalWindow);
        System.out.println("Old window title: " + driver.getTitle());

    }

    @Test
    public void testJSAlerts() throws Exception {

        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.cssSelector("#content li:nth-child(1)>button")).click();
        Alert alert = driver.switchTo().alert();

        Thread.sleep(1000);
        //alert.accept();
        alert.dismiss();
    }

    @Test
    public void testJSConfirm() throws Exception {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.cssSelector("#content li:nth-child(2)>button")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(1000);
        System.out.println(alert.getText());
        //alert.accept();
        alert.accept();
    }

    @Test
    public void testJSPrompt() throws Exception {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.cssSelector("#content li:nth-child(3)>button")).click();
        Alert alert = driver.switchTo().alert();
        //Thread.sleep(1000);
        alert.sendKeys("yo");
        //alert.accept();
        alert.accept();
    }

    @Test
    public void testFrames() throws Exception {
        driver.get("http://the-internet.herokuapp.com/tinymce");
        driver.switchTo().frame("mce_0_ifr");

        WebElement editor = driver.findElement(By.id("tinymce"));
        String textBefore = editor.getText();

        editor.clear();
        String typedText = "hi guys";
        editor.sendKeys(typedText);

        Assert.assertNotEquals(typedText, textBefore);

        driver.switchTo().defaultContent();
        Assert.assertFalse(driver.findElement(By.tagName("h3")).getText().isEmpty());
    }

    @Test
    public void testDropdown() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdownElement);
        select.getOptions().forEach(System.out::println);
        select.selectByValue("2");
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        System.out.println("Fist selected option" + firstSelectedOption);
        Assert.assertEquals("Option 2", firstSelectedOption.getText());
    }


    @Test
    public void testHover() {

        driver.get("http://rozetka.com.ua/");
        WebElement element = driver.findElement(By.xpath(".//*[contains(text(),'Смартфоны, ТВ и электроника')]/.."));

        Actions action = new Actions(driver);
        action.moveToElement(element).
                build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[contains(text(),'Мобильные телефоны')]/.."))).click();

    }

    @Test
    public void uploadFile() throws Exception {

        driver.get("http://the-internet.herokuapp.com/upload");
        String filename = "file.txt";

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(filename);
        File file = new File(resource.getFile());
        String path = file.getAbsolutePath();

        driver.findElement(By.id("file-upload")).sendKeys(path);
        driver.findElement(By.id("file-submit")).click();
        String text = driver.findElement(By.id("uploaded-files")).getText();
        assertThat(text, is(equalTo(filename)));
    }


    @Test
    public void fillForm() throws Exception {
        driver.get("http://derp-bear.herokuapp.com/forms/basic_form_example");

        driver.findElement(By.cssSelector("#first_name")).sendKeys("James");
        driver.findElement(By.cssSelector("#last_name")).sendKeys("James");
        driver.findElement(By.cssSelector("#email")).sendKeys("email@gmail.com");
        driver.findElement(By.cssSelector("#website_url")).sendKeys("site.com");

/*
        Select pets = new Select(driver.findElement(By.cssSelector("select#pet_select")));
        pets.selectByValue("23");
*/

        driver.findElement(By.cssSelector("button#pet_select")).click();
        new Actions(driver).moveToElement(driver.findElement(By.cssSelector("li[rel='2']"))).click().perform();
        driver.findElement(By.cssSelector("input#date_of_birth")).sendKeys("10221991");
        driver.findElement(By.cssSelector("label[for='female']")).click();
        driver.findElement(By.cssSelector("label[for='car']")).click();
      //  driver.findElement(By.cssSelector("#hi_im_hidden")).sendKeys("fdsfds");

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].removeAttribute('readonly','readonly')", driver.findElement(By.cssSelector("#read_only_text_area")));
    }
}