Feature: user is searching for a car Germany Paris

  Background:
    And user is landing page

  @tivix
  Scenario: invalid Country City, valid date
    When user selects country "Germainy"
    And user selects city "Paris"
    And user selects valid future date for pick-up
    And user selects valid future date for drop-off
    And user selects any car and click Search
    And user clicks on row 1 to rent
    And user can see invalid Summary of rental
