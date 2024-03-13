Feature: Orange HRM Add Employee Functionality

Background: 
Given Admin is already on Add Employee Page


						

@AddEmployee
Scenario: Add Employee
Given User enters employee name
And User enters login credentials
When User clicks Save button
And User enters employee registration details
Then User navigates to Employee Search Page
And User searches employee using employee id
And Employee record is displayed
					
 
					
				
				
