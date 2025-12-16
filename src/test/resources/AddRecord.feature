Feature: Add and Edit Record Test
  As a user
  I want to add and edit records in web tables
  So that I can manage table data

  Scenario: User adds a new record
    Given I am on the web tables page
    When I click on Add button
    And I fill the form with following data
      | firstName | Mehtap           |
      | lastName  | Parkinson        |
      | email     | mehtap@parkinson.com |
      | age       | 31               |
      | salary    | 1000             |
      | department| Engineering      |
    And I click on Submit button
    Then I should see the record with first name "Mehtap"

  Scenario: User edits an existing record
    Given I am on the web tables page
    When I click on Add button
    And I fill the form with following data
      | firstName | Mehtap           |
      | lastName  | Parkinson        |
      | email     | mehtap@parkinson.com |
      | age       | 31               |
      | salary    | 1000             |
      | department| Engineering      |
    And I click on Submit button
    And I click on Edit button for "Mehtap"
    And I update the department to "QA"
    And I click on Submit button
    Then I should see the department "QA" in the table