Feature: Validating Github user repositories

#  Background:
#    Given I hit the github base API URL

  @RunOnly
  Scenario: Datatable test
    When I test the datatable
      | Arbit     | Value |
      | 1     | harshit |
      | 2     | sneha |
    Then I see the following
      | Arbit     | Value |
      | 19     | harshit |
      | 29     | sneha |

  Scenario: Verify if user repository is returned successfully
    When I send the path using HTTP method
    Then I validate the positive response
      | 1     | arbit |
      | 2     | arbit2 |

  Scenario: Verify if user repository is not returned for incorrect authentication
    When I send the path using HTTP method without authentication
    Then I validate the unauthentication response


  Scenario: Verify optional parameters
    When I send the valid optional parameters
    Then I validate the response

  Scenario:  Verify forbidden cases
    When I send the response with token without permission
    Then I validate the forbidden access

  Scenario:  Verify products schema
    When I send the products path
    Then I validate the products schema
    And I validate the response time

