Feature: Validating Jira repository

  Background:
    Given I hit the JIRA base API URL for Post

  Scenario: Verify issue created successfully
    When I send the path and valid body using HTTP method
    Then I validate status code 201