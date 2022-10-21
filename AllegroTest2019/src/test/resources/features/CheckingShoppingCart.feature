Feature: Shopping basket test

  Scenario: Shopping cart validation summary

    Given Agree to the terms of the privacy policy
    When The user click, search for many
    And Complete the fields with the goods you are looking for
    And Choose one of sets
    Then Will check the correctness of the sum of the basket
    And Click button go to basket
    Then Close browser