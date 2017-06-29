package com.example.cucumber.steps;

import com.example.data.User;
import com.example.enums.PriceRange;
import com.example.pages.HotLineMainPage;
import com.example.pages.HotLineResultPage;
import com.example.pages.RegistrationPage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
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

    @When("^user open registration form$")
    public void userOpenRegistrationForm() throws Throwable {
        HotLineMainPage.openRegistrationForm();
    }

    @And("^fill registration form with with:$")
    public void fillRegistrationFormWithWithEmailNickAndPassword(List<User> users) throws Throwable {
        RegistrationPage.registerAs(users.get(0));
    }

    @Then("^following messages should be displayed:$")
    public void followingMessagesMessagesShouldBeDisplayed(List<String> errors) throws Throwable {
        List<String> actualMessages = RegistrationPage.getValidationMessages();
        Assert.assertEquals(errors, actualMessages);
    }

    @Then("^user should see message:(.*)$")
    public void userShouldSeeMessage(String expectedMessage) throws Throwable {
        String actualMessage = $("#mm-0 div.cell7.cell-768.cell6-980 > h1").text();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
