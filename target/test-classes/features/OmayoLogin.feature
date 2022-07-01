Feature: OmayoLogin Application

@OmayoLogin
Scenario Outline: Login with valid credentails
Given Navigate to url of omayo application
When Enter username as "<username>" and password as "<password>"
Then Click on omayoLogin button
And Verify User able to login based on expected "<loginstatus>" status
Examples:
|username       | password| loginstatus|
|arun    		    |pswd1    |failure   	 |
|SeleniumByArun	|Test143$	|success	   |
|motoori		    |pswd2		|failure 		 |

