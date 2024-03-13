Feature: Orange HRM Leave feature 
Background: Given User is logged in
Given Employee exists with given record
|firstname|lastname|jobtitle|employmentstatus|subunit|
|Ferland|Mendy|QA Engineer|Full-Time Contract|Quality Assurance|
Then User is already on Assign Leave page



@AssignLeave
Scenario: Assign leave to an employee
Given User enter the employee name and leave details
|leavetype|fromdate|todate|comments|leavestatus|
|US - Vacation|2024-07-08|2024-10-08|Test comments|Scheduled|
When User clicks Assign Leave button
And User clicks OK button
Then User navigates to Leave Search Page
And User searches leaves using leave type
And Leave record is displayed


				