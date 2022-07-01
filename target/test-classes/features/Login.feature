Feature: Application Login

Scenario: Login with valid credentials
Given Open the Application URL
And Navigate to Login page
When User enter valid username and valid password into the fields
And User clicks on Login button
Then Verify user is able to successfully login

Scenario: Login with valid username and invalid password
Given Open the Application URL
And Navigate to Login page
When User enter valid username and invalid password into the fields
And User clicks on Login button
Then Verify a warning informing user to provide valid credentials is displayed

Scenario: Login with invalid username and valid password
Given Open the Application URL
And Navigate to Login page
When User enter invalid username and valid password into the fields
And User clicks on Login button
Then Verify a warning informing user to provide valid credentials is displayed