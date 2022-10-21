Feature: Creating an account on the website correctly.

  Scenario Outline: Registering on the site.
    Given User open browser on authentication site.
    When Entering an <email> and going to the registration form.
    And Choose gender.
    And Complete the field with <firstName>
    And Enter <lastName>
    And Specify the <password>
    And Fill out the fields with date of birth.
    And Accept the newsletter and become our partner and press the registration button.
    Then You have been transferred to your account.
    Examples:
      | email     | firstName | lastName   | password        |
      | hereEmail | Tadeusz   | Rydzyk     | herePassword    |
      | hereEmail | Teofil    | Lubidzieci | herePassword    |
      | hereEmail | Adam      | Nowak      | herePassword    |
      | hereEmail | Jaroslaw  | Kaczka     | herePassword    |
      | hereEmail | Jarosław  | Psikuta    | herePassword    |

