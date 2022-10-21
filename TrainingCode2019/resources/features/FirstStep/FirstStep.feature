Feature: Create new address.

  Scenario Outline: Change of address details.
    Given The user goes to the login page.
    When Complete your login details.
    And Proceed to creating the address.
    And Create new addres
    And Specify <alias>
    And enter <address>
    And User fill <Zip or Postal Code>
    And He will give his <city>
    And Choose <nationality>
    And Fill <phone number> and submit
    And Check if the given data is correct
    Then Close the site.
    Examples:
      | alias    | address                  | Zip or Postal Code | city        | nationality    | phone number |
      | Guru     | ul. Krwawych Mocherow    | 87-111             | Troj miasto | United Kingdom | 56-666-23-55 |
      | Dyrektor | ul. Matki Polki          | 87-111             | Watykan     | United Kingdom | 56-655-69-69 |
      | Szefu    | ul. Bentleya             | 88-100             | Lichen      | United Kingdom | 56-655-70-44 |
      | Bezdomny | ul. Mocherow Wyzwolonych | 87-123             | Czestochowa | United Kingdom | 56-666-66-66 |
