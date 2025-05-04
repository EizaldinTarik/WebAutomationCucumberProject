Feature: Verify two products Feature
  Scenario: Verify that Two Products Are Purchased Successfully
    Given user enter homepage and login with valid username "Eizaldint" and valid password "11413" and wait for successful message
    When user enter laptop categories and add item to cart and then enter monitor categories and add item to cart
    Then user enter cart and compare prices with total and press purchase and user enter info to proceed

  Scenario: Adding the same product twice to the cart and verify that the quantity updates correctly.
    Given user enter homepage and login with valid username "Eizaldint" and valid password "11413" and wait for successful message
    When user enter laptop categories and add item twice to cart
    Then user click on cart and item added twice

  Scenario Outline: Attempt to log in with incorrect credentials and verify that an error message is displayed.
      Given user enter homepage and click on login
      When user enter invalid username "<invalidUsername>" and invalid password "<invalidPassword>" and press login
      Then an error message is displayed

      Examples:
        | invalidUsername  | invalidPassword  |
        | Eizaldin  | 11234     |

