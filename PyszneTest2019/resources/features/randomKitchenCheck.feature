Feature: Checking kitchen selection

  Scenario Outline: The user checks if the selected kitchen matches the search results
    Given The user accepts the privacy policy
    And Selects the given <address>
    Then It will check if the given city matches the title on the search page
    And Click show more at the end of the kitchen line
    When Choose one of random kitchen
    Then Check if all the results on the page have this kitchen
    Examples:
      | address               |
      | Stare Miasto, Wrocław |