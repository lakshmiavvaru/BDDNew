Feature: Login
  
  Scenario: SigninAnd validate Page Title and signout
    Given User Launch Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and password as "admin"
    And click on Login
    Then page title should be "Dashboard / nopCommerce administration"
    When User click on Logout link
    Then Page Title should be "Your store. Login"
    And close browser

Scenario Outline: SigninAnd validate Page Title and signout
    Given User Launch Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "<email>" and password as "<password>"
    And click on Login
    Then page title should be "Dashboard / nopCommerce administration"
    When User click on Logout link
    Then Page Title should be "Your store. Login"
    And close browser

    Examples: 
      |email    | password | 
      | admin@yourstore.com|   admin|
      | test@yourstore.com |   admin|

