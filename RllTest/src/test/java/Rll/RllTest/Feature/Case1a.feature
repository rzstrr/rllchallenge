Feature: Ralali Case 1A Service Test

  Scenario: I can get ALL service Response with CORRECT DATA TYPE from a filed named ID
    Given I can read url in service properties
    When I perform GET method through the service
    Then I can have "Integer" data type in all "id" response

  Scenario: I can get ALL service Response with CORRECT DATA TYPE from a filed named USERID
    Given I can read url in service properties
    When I perform GET method through the service
    Then I can have "Integer" data type in all "userId" response

  Scenario: I can get ALL service Response with CORRECT DATA TYPE from a filed named TITLE
    Given I can read url in service properties
    When I perform GET method through the service
    Then I can have "String" data type in all "title" response

  Scenario: I can get ALL service Response with CORRECT DATA TYPE from a filed named BODY
    Given I can read url in service properties
    When I perform GET method through the service
    Then I can have "String" data type in all "body" response


