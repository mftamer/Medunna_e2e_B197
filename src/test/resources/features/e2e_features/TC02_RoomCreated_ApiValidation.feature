@api @e2e
Feature: CreatedRoom_ApiValidation
  Scenario: Get all rooms
    Given Admin sends GET request for all rooms
    Then verify the room is created