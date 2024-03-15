@login
Feature: BookCart application demo

  Background: 
    Given User should navigate the link
    And User should clicks the login

  @reg
  Scenario: Login should be success
    And User enter the user name as "guna"
    And User enter the password as "Guna12345"
    When User Click the login button
    Then login should be success

  @smoke @reg
  Scenario: Login should be fail
    And User enter the user name as "gunasekaranb"
    And User enter the password as "guna123"
    When User Click the login button
    Then login should be fail