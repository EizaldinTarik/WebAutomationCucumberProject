Feature: Signup Feature
  Scenario: Verify that User Can Sign Up Successfully
    Given user enter homepage and Click on the Sign up button in the Header
    When user fill in the username "<username>" and password "<password>" and press register
    Then a success message should be displayed

    Scenario Outline: Try signing up with an existing username and verify the error message
      Given user enter homepage and Click on the Sign up button in the Header
      When user fill in the invalidUsername "<invalidUsername>" and invalidPassword "<invalidPassword>" and press register
      Then error message appear


      Examples:
        | invalidUsername | invalidPassword |
        | Eizaldint      | 11413|
