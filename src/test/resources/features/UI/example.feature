Feature: Demo UI Test

  Scenario: Demo UI Test Steps
    Given I am on the login page
    When I login
      | username | standard_user |
      | password | secret_sauce  |
    Then I should be on the home page