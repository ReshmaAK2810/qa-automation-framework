@Smoke @Login
Feature: Login functionality
  As a user of Sauce Demo
  I want to login to the application
  So that I can access Products page

  @Demo
  Scenario: Login to Sauce demo
    Given I am on the SauceDemo login page
    When I enter username and password
    And I click on the submit button
    Then I should see the Products page

  @Negative @Demo
  Scenario: Invalid login using wrong credentials
    Given I am on the SauceDemo login page
    When I enter invalid username and password
    And I click on the submit button
    Then an error message "Epic sadface: Username and password do not match any user in this service" should be displayed

  @Negative @Demo
  Scenario Outline: Display appropriate error when either username or password field is empty
    Given I am on the SauceDemo login page
    When the user enters "<usernameKey>" as username and "<passwordKey>" as password
    And I click on the submit button
    Then an error message "<errorMessage>" should be displayed

    Examples:
      | usernameKey | passwordKey | errorMessage                       |
      |             | passwordKey | Epic sadface: Username is required |
      | usernameKey |             | Epic sadface: Password is required |




