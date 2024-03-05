@api
Feature: CreatedRoom_ApiValidation
  Scenario: Get room by ID
    Given Admin sends GET request for all rooms
    Then verify the room is created