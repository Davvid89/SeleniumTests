Feature:

  Scenario Outline: Shopping and payment check.
    Given the user goes to the store's website
    When Log in to the site
    And Search and choose Hummingbird Printed Sweater
    And Check the discount and choose the <size>
    And choose <quantity>
    And add product to cart and click checkout
    And Proceed to checkout
    And Confirm the address and select a delivery method
    And Method of payment choose and agree to the terms of service
    And submit your order
    Then Do a screenshot
    Examples:
      | size |quantity|
      | L    |   5    |