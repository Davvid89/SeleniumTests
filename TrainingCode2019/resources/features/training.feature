Feature: Training

  Scenario: test without purpose.
    Given something is done
    When PierwszeSłowo is printed
    And 'mieści sie w stringu' przykład
    And 22 is printed.

    But we can use list as well
      | cat  |
      | dog  |
      | lion |


  Scenario Outline: singing
    Given people tryingi singing
    When now <person> trying
    Then sings <how>
    Examples:
      | person | how       |
      | Adrian | beautiful |
      | Dawid  | ugly      |
      | Ania   | tak sobie |