package com.qa.orangehrm.stepdefs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.qa.orangehrm.pages.AddEmployeePage;
import com.qa.orangehrm.pages.EmployeeSearchPage;
import com.qa.orangehrm.pages.HomePage;
import com.qa.orangehrm.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeSearchPageDefs {
	EmployeeSearchPage employeeSearchPageObj;
	LoginPage loginPageObj;
	AddEmployeePage addEmployeePageObj = new AddEmployeePage();
	String expectedEmployeeId;
	HomePage homePageObj = new HomePage();
	@Given("User enters employee id")
	public void user_enters_employee_id() {
		expectedEmployeeId = employeeSearchPageObj.enterEmployeeId();
	}

	@When("User clicks search button")
	public void user_clicks_search_button() {
		employeeSearchPageObj.clickSearchButton();
		
	}

	@Then("Particular employee record should only be displayed")
	public void particular_employee_record_should_only_be_displayed() {
		List<HashMap<String, String>> employeeSearchResultsList;
		employeeSearchResultsList = employeeSearchPageObj.getEmployeeRecords();
		Assert.assertEquals(1, employeeSearchResultsList.size());
		for (int i = 0; i < employeeSearchResultsList.size(); i++) {
			HashMap<String, String> employeeDetailsHashMap = employeeSearchResultsList.get(i);
			for (Object obj : employeeDetailsHashMap.keySet()) {
				String actualEmployeeId = employeeDetailsHashMap.get("Id");
				Assert.assertEquals(expectedEmployeeId, actualEmployeeId);
			}

		}
	}
	
	@Given("Employee exists with given record")
	public void employee_exists_with_given_record(DataTable employeeDetailsTable)   {
	    List<Map<String,String>> employeeDetailsList = employeeDetailsTable.asMaps(String.class,String.class);
	    addEmployeePageObj.createEmployeeRecord(employeeDetailsList);
	    loginPageObj=addEmployeePageObj.doLogout();
	}
	@Then("User is already on Employee Search Page")
	public void user_is_already_on_employee_search_page() {
		homePageObj = loginPageObj.doLogin();
		employeeSearchPageObj=homePageObj.clickOnPIMPageLink();
		
	}


}
