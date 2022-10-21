Feature: google search

  Scenario Outline: User can search any keyword in Google.
    Given An open browser with google.
    When <keyWord> word has been written into the input field and submitted
    Then First result contains <keyWord> word
    And Close the browser
    Examples:
      | keyWord  |
      | Selenium |
      | Cucumber |