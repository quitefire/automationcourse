Feature: Hotline search

  @sanity
  Scenario: search for iphone
    Given a user is on the main hotline page
    When user searches for iphone
    And selects $2500_3500 price range for found results
    Then all results prices are within the select price range


  @regression
  Scenario Outline: search for <product>
    Given a user is on the main hotline page
    When user searches for <product>
    And selects <range> price range for found results
    Then all results prices are within the select price range

    Examples:
      | product | range      |
      | iphone  | $2500_3500 |
      | iphone  | $3500_5000 |