Feature: Creating a new account on the site

  Scenario Outline: Steps to create a new user
    Given accepting the privacy policy
    And Go to registration form
    And Will provide his <email>
    And Provide your <username>
    And He will give his <password>
    And Acceptance of the website's regulations
    And Clicks the create account button
    Examples:
      | email   | username | password |
      | ******* | *******  | ******   |