Feature: navigate to home page
  Scenario: user looks for a car to rent
    When user goes on "home page"
    Then title is "Car rent"