Feature: Password change test

  Scenario: Validation of the password change
    Given User is on login page and accept cookie policy.
    When Fills out login details and click login
    And Click login.
    And Goes to the password change settings
    And Click change password
    And Fill in the field with the incorrect current password
    And Fill in the field with the new password
    And Fill out the confirmation box for the new password
    And Click change
    Then An error message appears
    And User close browser

    Scenario: Correct password change
      Given User is on login page and accept cookie policy.
      When Fills out login details and click login
      And Click login.
      And Goes to the password change settings
      And Click change password
      And Fill the field with the current password
      And Fill the field with new password
      And Fill the field with confirm new password
      And Click change
      Then Validates the correct password change message
      And Close the browser page