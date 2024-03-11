@db @e2e
Feature: CreatedRoom_DBValidation
  Scenario: CreatedRoom_DBValidation
    Given Admin connects to the database
    When admin executes query for the room
    Then validate created room from the resultset
