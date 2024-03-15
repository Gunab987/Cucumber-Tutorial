@addto
Feature: BookCart Application Demo

  Background: 
    Given User should navigate the link login

  @CleanUp
  Scenario Outline: Add product to cart
    #Given User should navigate the link login
    And user should login as "<username>" and "<password>"
    And user search a book as "<book>"
    When user add book to cart
    Then cart badge should be updated

    @gow
    Examples: 
      | username | password  | book              |
      | guna     | Guna12345 | Birthday Girl     |
      | gunass   | Guna12345 | Like a Love Story |
    #@gun
    #Examples: 
      #| username | password  | book                 |
      #| guna     | Guna12345 | Before We Were Yours |
      #| gunass   | Guna12345 | Like a Love Story |