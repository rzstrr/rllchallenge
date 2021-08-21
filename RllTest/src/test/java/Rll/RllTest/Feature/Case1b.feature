Feature: Ralali Case 1B Service Test

  Scenario: I can GET CORRECT response based on INPUTED Payload
    Given I can read url in service properties
    When I post payload with these attribute ["recomendation","motorcycle",12]
    Then I should have the same response with sent payload