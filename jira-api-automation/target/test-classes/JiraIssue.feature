Feature: Validating Jira repository

  Background:
    Given I hit the JIRA base API URL

#  @RunOnly
  Scenario: Verify issue created successfully
    When I send the path and valid body using HTTP method
    Then I validate issue created successfully with status code 201

  @RunOnly
  Scenario: Verify issue updated successfully
    When I send the path and valid body using HTTP method
    Then I validate issue created successfully with status code 201
    When I change body using HTTP method
    Then I validate issue updated successfully with status code 204

#  @RunOnly
  Scenario: Verify issue fetched successfully
    When I send the path and valid body using HTTP method
    Then I validate issue created successfully with status code 201
    When I try to fetch the issue
    Then I validate issue fetched successfully with status code 200

#  @RunOnly
  Scenario: Verify attachment added successfully
    When I send the path and valid body using HTTP method
    Then I validate issue created successfully with status code 201
    When I add an attachment to the issue
    Then I validate attachment added successfully