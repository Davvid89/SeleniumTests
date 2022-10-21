Feature: Checking order selection

  Scenario Outline: The user checks the correct operation of the order filter
    Given User accepts the privacy policy
    And Complete the <address> field
    And Will choose one of the order amounts
    Then Check if all the result on the page have this amounts
    Examples:
      | address               |
      | Stare Miasto, Wrocław |