package com.courses.week3.hotlinev1.pages;

import com.courses.week3.hotlinev1.enums.PriceRange;
import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class HotlineResultPage extends BasePage {

    private By prices = By.cssSelector("#catalogue div.text-14.text-13-480.orng");

    public HotlineResultPage(WebDriver driver) {
        super(driver);
    }

    public HotlineResultPage selectPriceRange(PriceRange range) {
        By priceRangeLocator = By.cssSelector(String.format("#filters > div.cell.group-gr-185.full-list div:nth-child(%d)>a",
                range.getIndex()));
        closeBottomBar();
        wait.until(ExpectedConditions.elementToBeClickable(priceRangeLocator)).click();
        return this;
    }

    private HotlineResultPage closeBottomBar() {
        driver.findElement(By.cssSelector("a.hide")).click();
        return this;
    }


    public List<Integer> selectAllPrices() {
        final String regex = "[а-яА-Я\\s\\u2009]";

        return driver.findElements(prices).
                stream().
                map(WebElement::getText).
                map(s -> NumberUtils.toInt(s.replaceAll(regex, ""), 0)).
                collect(toList());
    }

}