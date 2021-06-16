Feature: Validating Github user repositories

  Background:
    Given I hit the github base API URL for Post

  Scenario: Verify unprocessable entity error
    When I send the path and invalid body using HTTP method
    Then I validate status code 422

#    must read - redirect
  Scenario: Verify if user repository is created successfully
    When I send the path and valid body using HTTP method
    Then I validate record has been created

  Scenario: Verify record is deleted successfully
    When I delete the repo using HTTP method
    Then I validate no record is present

  Scenario: Verify unauthorized error
    When I dont send the token
    Then I validate unauthorized error

  Scenario: Verify if user repository is returned successfully
    When I send get request using HTTP method
    Then I validate successful creation of record