Feature: Register user with some data
  Scenario: User registration with data table
    Given User on registration page
    When user enters data
      | firstname | sumit |
      | lastname  | raut  |
      | age       | 35    |
    And Submits form
      | column 1 | column 2 |
      | data 1   | data 2 |
    Then success message is shown
