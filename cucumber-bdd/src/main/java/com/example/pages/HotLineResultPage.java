package com.example.pages;

import com.codeborne.selenide.SelenideElement;
import com.example.enums.PriceRange;
import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.util.stream.Collectors.toList;

public class HotLineResultPage {

    public static void selectPriceRange(PriceRange range) {
        closeBottomStatisticsPanel();
        String priceRangeLocator = String.format("#filters > div.cell.group-gr-185.full-list div:nth-child(%d)>a",
                range.getIndex());
        $(priceRangeLocator).click();
    }

    private static void closeBottomStatisticsPanel() {
        SelenideElement bottomPanel = $("a.hide");
        if (bottomPanel.isDisplayed()) {
            bottomPanel.click();
        }
    }

    public static List<Integer> selectAllPrices() {

        final String regex = "[^0-9]";
        return $$("#catalogue div.text-14.text-13-480.orng").
                stream().
                map(WebElement::getText).
                map(s -> NumberUtils.toInt(s.replaceAll(regex, ""), 0)).
                collect(toList());
    }
}
