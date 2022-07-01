Feature: Aplliaction Register

Scenario: Register with mandatory fields
Given Enter url of application
And Click on account dropdown
Then Select register button
And Enter the required fields
Then Click on continue button
And Verify that account created or not

Scenario: Register with All Required Field
Given Enter url of application
And Click on account dropdown
Then Select register button
And Enter All the fields
Then Click on continue button
And Verify that account created or not

Scenario: Register with Alraedy Existing Field
Given Enter url of application
And Click on account dropdown
Then Select register button
And Enter the required Fields and  email field with already existing mail
Then Click on continue button
And Verify that account not created with warning message

