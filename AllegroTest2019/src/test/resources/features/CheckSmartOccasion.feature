Feature: operation of the smart bargains tab

#  Scenario: checking weekend prices in the smart bargains tab

#    Given I'm on the home page
#    When select the tab benefit and the smart opportunities section
#    And will check on weekend occasions that the items contain the word
#    Then check that the main price is lower than the crossed out price
#    And close browser
#
#  Scenario: checking price in: "bestseller with free delivery"
#
#    Given I'm on the home page
#    When select the tab benefit and the smart opportunities section
#    And checks prices in the bestseller category with free delivery
#    Then close browser

#  Scenario: Check price on the: "Most popular Smart! opportunities"

#    Given I'm on the home page
#    When select the tab benefit and the smart opportunities section
#    And will choose one of category in most popular opportunities
#    And check that the prices are below the crossed out prices in the category concerned
#    Then close browser

#  Scenario: Checking price in: "Take advantage of super offers and free delivery"
#
#    Given I'm on the home page
#    When select the tab benefit and the smart opportunities section
#    And check price in the tab: Take advantage of super offers and free delivery
#    Then close browser

  Scenario: Check price in section: "Check out all the unique Smart! opportunities"

    Given I'm on the home page
    When select the tab benefit and the smart opportunities section
    Then check price in section: Check out all the unique Smart! opportunities
    And close browser