@api @e2e
Feature: CreatedRoom_ApiValidation
  Scenario: Get room by ID
    Given Admin sends GET request for a room by its id
    Then verify response body of the created room