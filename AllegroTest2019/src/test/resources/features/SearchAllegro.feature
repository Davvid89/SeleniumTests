Feature: My first steps in search

  Scenario Outline: Sample searches

    Given User is on main page and acceptance of the cookies policy
    When the user enters the <password> of interest
    And click search
    And Check result title
    And Results should contains searched word
    Examples:
      | password |
      | garnki   |
#      | patelnie          |
#      | noże szefa kuchni |