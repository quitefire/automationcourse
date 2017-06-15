package com.courses.week3.conciseapi.pages;

import com.courses.week3.conciseapi.wrappers.ConciseAPI;
import com.courses.week3.hotlinev1.enums.PriceRange;
import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class HotlineResultPage extends ConciseAPI {

    private By prices = By.cssSelector("#catalogue div.text-14.text-13-480.orng");

    public HotlineResultPage selectPriceRange(PriceRange range) {
        By priceRangeLocator = By.cssSelector(String.format("#filters > div.cell.group-gr-185.full-list div:nth-child(%d)>a",
                range.getIndex()));
        closeBottomBar();
        click(priceRangeLocator);
        return this;
    }

    private HotlineResultPage closeBottomBar() {
        click(By.cssSelector("a.hide"));
        return this;
    }

    public List<Integer> selectAllPrices() {
        final String regex = "[^0-9]";

        return findAll(prices).
                stream().
                map(WebElement::getText).
                map(s -> NumberUtils.toInt(s.replaceAll(regex, ""), 0)).
                collect(toList());
    }


}