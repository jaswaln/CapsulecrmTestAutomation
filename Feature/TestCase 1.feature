Feature: Navigate to Url Add person and Add Case verify correct case created with open status

    @TestCase1
    Scenario Outline: Verify the correct case created with same person
        Given  Navigate to URL
        When Login with correct credentials
        Then Click on person icon and add a person "<Title>" "<firstname>" "<lastname>" "<Job Title>" "<Tag>"
        And Click on cases icon
        And Click on add case button
        And Create a new case with the added person "<AddCasePerson>" "<CaseName>" "<CaseDescription>"
        And Verify the correct case got created for the same person "<AddCasePerson>" "<CaseName>"
        And verify the case status Open
        And close the browser
    Examples:
    |   Title   |   firstname   |   lastname    |   Job Title   |   Tag     |  AddCasePerson    |   CaseName    |   CaseDescription |
    |   Mr      |   Jhon        |   Abc         |   Automation  |   TestTag |   Jhon Abc        |   CaseTest    |   CaseDescATest   |


