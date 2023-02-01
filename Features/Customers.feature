Feature: Customers

 Scenario: Add New Customer
    Given User Launch Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and password as "admin"
    And click on Login
    Then User can view Dashboard 
    When User click on Customers Menu
    And click on Customers menu item
    And click on Add new button
    Then User can view Add new customers page
    When User enters customer info
    And click on save button
    Then User can view confirmation message "The new customer has been added successfully."
    And close browser
    
    Scenario: Search Customer by Email
    Given User Launch Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and password as "admin"
    And click on Login
    Then User can view Dashboard 
    When User click on Customers Menu
    And click on Customers menu item
    And User enters email in searchbox
    When click on search button
    Then User should find the email in the search results table
    And close browser
