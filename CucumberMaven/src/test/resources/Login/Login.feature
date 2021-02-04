@Login
Feature: To validate Login Application 
1)Valid case
2)Invalid case 
Background:
Given we should be in homepage
@validcase
#Scenario: To test login with Valid scenario
#When Enter the valid name "Admin"
#And Enter valid password "admin123"
#And click on Login validButton
#Then Login should be successful
#
#Scenario: To test login with Valid scenario
#When Enter the valid name "Admin"
#And Enter valid password "admin123"
#And click on Login validButton
#Then Login should be successful

Scenario Outline: To test login with different data
When Enter the valid name <"user">
And Enter valid password <"pwd">
And click on Login validButton
Then I should see name as <"loginName">

Examples:
|user |pwd		 |LoginName		|
|Admin|admin123|Welcome Paul|
|Admin|admin123|Welcome Paul|

@invalidcase
Scenario: To test login with Invalid scenario
When Enter the invalid name "Admin123"
And Enter invalid password "admin123"
And click on Login invalidButton
Then I should see the invalid credential as "Invalid credentials"