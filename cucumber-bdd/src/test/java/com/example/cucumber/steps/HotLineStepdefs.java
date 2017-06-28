package com.example.cucumber.steps;

import com.example.enums.PriceRange;
import com.example.pages.HotLineMainPage;
import com.example.pages.HotLineResultPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class HotLineStepdefs {

    private PriceRange range;


    @Given("^a user is on the main hotline page$")
    public void aUserIsOnTheMainHotlinePage() throws Throwable {
        HotLineMainPage.openPage();
    }

    @When("^user searches for (.*)$")
    public void userSearchesForIphone(String product) throws Throwable {
        HotLineMainPage.searchFor(product);
    }

    @And("^selects (.*) price range for found results$")
    public void selects_PriceRangeForFoundResults(PriceRange priceRange) throws Throwable {
        range = priceRange;
        HotLineResultPage.selectPriceRange(priceRange);
    }

    @Then("^all results prices are within the select price range$")
    public void allResultsPricesAreWithinTheSelectPriceRange() throws Throwable {
        List<Integer> prices = HotLineResultPage.selectAllPrices();

        prices.forEach(price -> assertTrue("Price is out of the range",
                price >= range.getMinPrice() && price <= range.getMaxPrice()));
    }

}
