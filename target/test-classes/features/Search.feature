Feature: Apllication Search

Scenario: Search with existing product
Given Open url of application
Then Enter product name to search
And Click on search icon
And Verify the product displayed correctly

Scenario: Search with non existing product
Given Open url of application
Then Enter the non existing product
And Click on search icon
Then Verify that the product is not exist

Scenario: Search with not entering product
Given Open url of application
Then Do not enter any product
And Click on search icon
Then Verify that the product is not exist