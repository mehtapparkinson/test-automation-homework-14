Feature: Click Button Test
  As a user
  I want to click the Click Me button
  So that I can see the dynamic click message

  Scenario: User clicks Click Me button and sees success message
    Given I am on the elements page
    When I click on Buttons option
    And I click on Click Me button
    Then I should see the message "You have done a dynamic click"