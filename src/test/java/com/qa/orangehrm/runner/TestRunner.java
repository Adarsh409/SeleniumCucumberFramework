package com.qa.orangehrm.runner;

import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//Features",//Path for feature file
		glue = {"com.qa.orangehrm.stepdefs"}, //Path of step definition files.
		dryRun = false, // To check if there is a corresponding method available for each of the step without executing steps.
		monochrome = true, // To view the console logs in a readable format.
		plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }// To generate reports
		//tags="@AddEmployee or @AssignLeave 
		)
public class TestRunner{
	
}
