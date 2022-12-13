Feature: Add Employee

  Background:
    When user enters valid username and valid password
    And user clicks on login button
    When user clicks on PIM option
    And user clicks on Add Employee button

  @sprint3 @regression
  Scenario: Adding one employee
    #Given user is navigated to HRMS application
    And user enters firstname and lastname
    And user clicks on save button
    Then employee added successfully

    @test1
    Scenario: Adding one employee using feature file
      And user enters "Tatiana" and "Adelina"
      And user clicks on save button
      Then employee added successfully

      @Outline
      Scenario Outline: Adding multiple employees using feature file
        And user enters "<firstName>" and "<lastName>"
        And user clicks on save button
        Then employee added successfully
        Examples:
          | firstName | lastName |
          |Tatiana    |Haughton  |
          |Ayden      |Johnson   |
          |Adelina    |Barrow    |

        @datatable
        Scenario: Adding multiple employees using data table
          When user adds multiple employees and verifies they are added successfully
          |firstName|middleName|lastName|
          |zara     |MS        |camila  |
          |birgul   |MS        |Reeno   |
          |Bob      |MS        |Jones   |

          @excel
          Scenario: Adding multiple employees using Excel file
            When user adds multiple employees from excel using "EmployeeData" and verifies it

