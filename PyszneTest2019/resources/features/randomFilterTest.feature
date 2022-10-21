Feature: Random order in pyszne.pl

  Scenario Outline: User can make a random order at pyszne.pl
    Given accepts the policy of cookies
    When Choose an <address>
    And the user selects a random kitchen
    And Sort the result
    And Choose the minimum order amount
    And Will choose the cos of delivery
    Then compares the search results on the page
    Examples:
      | address               |
      | Stare Miasto, Wrocław |
#      | Wejherowska 25, 54-239 Wrocław |
