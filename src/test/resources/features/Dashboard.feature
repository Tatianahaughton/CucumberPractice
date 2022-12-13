Feature: Dashboard functionality
  //tag each test case to keep track

  @sprint3 @regression @tc1106
  Scenario: Verify dashboard
    #Given user is navigated to HRMS application
    When user enters valid username and valid password
    And user clicks on login button
    Then user is successfully logged in
    Then user verify dashboard page
    Then user verifies all dashboard tabs
    |Admin|PIM|Leave|Time|Recruitment|Performance|Dashboard|Directory|
