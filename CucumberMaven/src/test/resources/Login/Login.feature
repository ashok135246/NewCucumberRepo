Feature: To validate Login Application 
1)Valid case
2)Invalid case 
@validcase
Scenario: To test login with Valid scenario
Given Login application present
When Enter valid credentials
Then Login successful
@invalidcase
Scenario: To test login with Invalid scenario
Given Login application present
When Enter invalid credentials
Then Login unsuccessfull