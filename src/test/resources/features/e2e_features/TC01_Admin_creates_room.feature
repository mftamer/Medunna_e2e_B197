@room_creation @e2e
Feature: Admin creates room
  Background:
    Given admin goes to "https://medunna.com/" homepage
    And clicks on userIcon
    And clicks on signIn option
    And enters username in the Username input field
    And enters password in the password input field
    And clicks on submit button

  Scenario Outline: Room creation
    When admin clicks on Items&Titles button
    And clicks on Room option
    And clicks on Create A New Room button
    And enters roomNumber into Rooom Number field
    And chooses "DELUXE" from the dropdown
    And clicks on Status box
    And enters "<price>" into Price field
    And enters "<description>" into Description field
    And clicks on Save button
    Then verify the new room is created

    Examples:
      | price | description |
      | 1400  | SeaView     |