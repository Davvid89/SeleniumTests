Feature: Checking base function on homepage

  Scenario Outline: Basic functionalities of homepage
    Given accepts the policy of cookies
    And He will type the <word> he is interested in
    And Click search button
    And Change page view to list
    Then Check search result
    Examples:
      | word   |
#      | Tissot |
      | i9    |

