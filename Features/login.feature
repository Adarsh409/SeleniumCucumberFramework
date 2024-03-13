Feature: Orange HRM login functionality

@AdminValidLogin
Scenario Outline: Admin login with valid credentials
				Given User is on Login page
				When User enters  "<Username>" as username and "<Password>" as password
				And User clicks Login button
				Then User lands on user homepage page with url "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"
	Examples:
	|Username|Password|
	|Admin|admin123|	
	
	
			
@AdminInvalidLogin			
Scenario Outline: Admin login with invalid credentials
				Given User is on Login page
				When User enters  "<Username>" as username and "<Password>" as password
				And User clicks Login button
				Then "Invalid credentials" error message is displayed
	Examples:
	|Username|Password|
	|Admin|qwerty|
	|Qa123|admin123|
	|Test|password|
							
				