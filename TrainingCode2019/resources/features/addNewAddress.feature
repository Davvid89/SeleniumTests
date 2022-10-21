Feature: Change user information after login

  Scenario: Add new address

    Given User is logged in to CodersLab shop
    When User goes to UserAddressPage
    And User click add new address
    And User fills all requierd fields and submits