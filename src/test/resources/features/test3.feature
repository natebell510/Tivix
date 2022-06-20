Feature: user is searching for a car Poland Wroclaw

  Background:
    And user is landing page

  @tivix
  Scenario: valid Country-City reference, valid date
    When user selects country "Poland"
    And user selects city "Wroclaw"
    And user selects valid future date for pick-up
    And user selects valid future date for drop-off
    And user selects any car and click Search
    And user clicks on row 1 to rent
    And user can see Summary of rental
    And user enters first name, last name, card number, email
    Then user clicks Rent