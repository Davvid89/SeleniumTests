Feature: My first account creation

  Scenario Outline: Creating a new user account

    Given Acceptance of the privacy policy
    When the user goes to the registration form
    And the user provides his <emailaddress>
    And User provides his <pass>
    And User give <day>, <month> and <year> of birth
    And The user accepts the permission
    And Click create an account button
    And the user gets confirmation of the account creation
    Examples:
      | emailaddress    | pass              | day | month    | year |
      | *************** | ***************** | **  | ******** | **** |
