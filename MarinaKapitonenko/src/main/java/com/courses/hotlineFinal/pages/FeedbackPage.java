package com.courses.hotlineFinal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.net.URL;
import java.util.List;

public class FeedbackPage extends BasePage{

	private String nameInput = "input[name='visitor_name']";
	private By submitBtn = By.cssSelector("#feedback input[type='submit']");
	private By subjectDropdown = By.cssSelector(".select .text");
	private By subjectOption = By.cssSelector(".dropdown li");
	private By inputFile = By.cssSelector("#feedback div.js-image input[name='images[]']");

	public FeedbackPage(WebDriver driver) {
		super(driver);
		this.url = "/feedback/";
	}

	public FeedbackPage selectSubject(String text){
		findOne(subjectDropdown).click();
		List<WebElement> options = findAll(subjectOption);

		WebElement selected = options.stream().filter(o -> o.getText().equals(text)).findFirst().orElse(null);
		selected.click();
		return this;
	}

	public String getSelectedSubject(){
		return findOne(By.cssSelector(".select .text")).getText();
	}


	public FeedbackPage submitForm(){
		closeBottomBar();
		findOne(submitBtn).click();
		return this;
	}

	public boolean hasValidationErrors() {
		if (!driver.getCurrentUrl().equals(urlTo(this.url))){
			return false;
		}

		try {
			return !fieldGetErrorMessage(nameInput).isEmpty();
			} catch (TimeoutException ignored){}

		return false;
	}

	protected String fieldGetErrorMessage(String selector) {
		return findOne(selector + " + div[class='errors']").getText();
	}

	public String fileInputGetInvalidTypeErrorMessage() {
		WebElement error = findOne("div.errors.error-type");
		return error.getAttribute("style").contains("display") ? null : error.getText();
	}

	public void uploadFile(String fileName) {
		WebElement uploadFileField = findOne(inputFile);
		File file = getFileFromResources(fileName);
		uploadFileField.sendKeys(file.getAbsolutePath());
	}

	public List<WebElement> getFileInputs(){
		return findAll(inputFile);
	}

	private File getFileFromResources(String fileName) {
		//ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		ClassLoader classLoader = getClass().getClassLoader();
		URL resourceURL = classLoader.getResource(fileName);
		if (resourceURL == null) {
			throw new RuntimeException("Can't find such file in classpath.");
		}
		return new File(resourceURL.getFile());
	}
}
