Feature: Free CRM Login  Scenario

  
  Scenario Outline: Free CRM Invalid login Test Scenario
    Given user is already on Login Page
    When user enters the username "<userName>" and password "<password>"
    Then user should click on  Login Page
    Then user should remain in LoginPage
    Then user should close the browser

    Examples: 
      | userName                   | password  | 
      | mamidisrisaiteja@gmail.com | Srisai@90 | 
      
      
    @run
    Scenario Outline: user is able to create new contact 
    Given user is already on Login Page
    When user enters the username "<userName>" and password "<password>"
    Then user should click on  Login Page
    Given  user is already on homepage
    When   user clicked on contacts link
    Then   user clicked on Create button
    Then   user enters the firstname "<firstname>"and the lastname "<lastname>"
    Then   user clicks on save button
    Then   verify new contact created
 
    
      Examples: 
      | userName                   | password  |    |firstname | lastname |
      | mamidisrisaiteja@gmail.com | Srisai@90 |    |jasmitha  | sri      |
      
