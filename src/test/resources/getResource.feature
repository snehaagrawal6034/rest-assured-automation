Feature: Validating Github user repositories

  Background:
    Given I hit the github base API URL

  Scenario: Verify if user repository is returned successfully
    When I send the path using HTTP method
    Then I validate the positive response

  Scenario: Verify if user repository is not returned for incorrect authentication
    When I send the path using HTTP method without authentication
    Then I validate the negative response

  Scenario: Verify optional parameters
    When I send the valid optional parameters
    Then I validate the response