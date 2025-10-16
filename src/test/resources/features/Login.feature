Feature: Login functionality
  As a user of Sauce Demo
  I want to login to the application
  So that I can access Products page

  Scenario: Login to Sauce demo
    Given I am on the SauceDemo login page
    When I enter username and password
    And I click on the submit button
    Then I should see the Products page

