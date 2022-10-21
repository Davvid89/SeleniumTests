Feature: Login to user account

  Scenario: Incorrect login details

    Given User is on login page.
    When Accept cookie policy.
    And Will enter the wrong login
    And Will enter the wrong password
    And Click login button
    Then You get a message that the password or login is incorrect
    And Close the browser

    Scenario: Correct login details
      Given User is on login page.
      When Accept cookie policy.
      And Will enter the login
      And Will enter the password
      And Click login
      Then Compare the login with the login of the logged in user